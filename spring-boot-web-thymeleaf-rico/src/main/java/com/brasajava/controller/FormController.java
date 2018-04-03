package com.brasajava.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.brasajava.bean.Contact;
import com.brasajava.bean.Person;
import com.brasajava.repository.PersonRepository;

@Controller
public class FormController {
	/**
	 * Este repositorio salva os objetos person e os objetos contact relacionado
	 * com ele, porque a classe Person foi mapeada para usar CascadeType.ALL.
	 * Por essa razão não preciso usar o ContactRepository.
	 */
	@Autowired
	PersonRepository personRepository;

	/**
	 * Este metodo está mapeado para /form usando o método GET. Ele recebe uma
	 * pessoa por parametro e adiciona um contato com o id = -1 para que seja
	 * possível identificar um contato específico e saber se esse contacto está
	 * salvo no banco de dados. Os contatos com id negativos não estão salvos no
	 * banco de dados.
	 * 
	 * @param person
	 *            Este parametro é criado pelo Spring e estará diponível para a
	 *            view como atributo person.
	 * @return form é o nome da view que esta na pasta templates/form.html para
	 *         o thymeleaf.
	 */
	@RequestMapping(value = "/form", method = RequestMethod.GET)
	public String showForm(Person person,Model model) {
		person.getContacts().add(new Contact((long) -1));
		model.addAttribute("listOfPeople", personRepository.findAll());
		return "form";
	}

	/**
	 * Este método é muito parecido com o método showForm, as diferenças são: --
	 * na anotação @RequestMapping tem o argumento params="id" que serve para
	 * que o Spring possa diferenciar qual dos metodos ele deve executar já que
	 * os dois estão mapeados para /form com o método GET, se no request existe
	 * o parametro id então esse método seria o escolhido pelo Spring, em caso
	 * de que o parametro id não exista no request então o método showForm seria
	 * o escolhido pelo Spring. -- Usaremos o parametro id para buscar no banco
	 * de dados a pessoa correspondente e configurar o objeto person recebido
	 * por argumento, já que esse objeto já estará diponivel para a view.
	 * 
	 * @param person
	 *            objeto criado pelo Spring configurado con los dados del objeto
	 *            person extraído da base de dados.
	 * @param id
	 *            de una persona já registrada no banco de dados.
	 * @return form é o nome da view que esta na pasta templates/form.html para o
	 *         thymeleaf.
	 */
	@RequestMapping(value = "/form", method = RequestMethod.GET, params = "id")
	public String showFormPopulated(Person person, @RequestParam(value = "id", required = true) Long id,Model model) {
		Person p = personRepository.findOne(id);
		if (p != null) {
			person.setAge(p.getAge());
			person.setName(p.getName());
			person.setContacts(p.getContacts());
		}
		model.addAttribute("listOfPeople", personRepository.findAll());
		return "form";
	}

	/**
	 * Este Metodo esta mapeado para /from usando o método POST e params="action=save".
	 * Note que nesse caso não só é necessário que existe o parametro, mas que o valor também seja igual
	 * ao valor especificado. 
	 * @param person criada e populada com os dados do form pelo Spring.
	 * @param bindingResult para certificar se o binding ocorreu corretamente.
	 * @return form se houve erro no binding e result se ocorreu todo corretamente.
	 */
	@RequestMapping(value = "/form", method = RequestMethod.POST, params = "action=save")
	public String saveForm(@Valid Person person, BindingResult bindingResult,Model model) {
		/*
		 * Se houver algum erro no binding, como de validação por exemplo, voltaria a view form
		 * indicando os erros.
		 */
		if (bindingResult.hasErrors()){
			model.addAttribute("listOfPeople", personRepository.findAll());
			return "form";
		}
		/*
		 * Igualando, todos os ids que tenham valor negativos, a zero para que hibernate veja que não estão
		 * salvos no banco de dados.
		 */
		for (Contact c : person.getContacts()) {
			if (c.getId() < 0)
				c.setId(0l);
		}

		/*
		 * Se todo estiver correto salva o objeto person e os objetos contact existentes na lista de contatos
		 * do objeto person porque na classe Person a propriedade contacts(lista de contato) esta anotada com
		 * a opção cascade=CascadeType.ALL
		 */
		personRepository.save(person);
		return "result";
	}

	/**
	 * Este Metodo esta mapeado para /from usando o método POST e params="action=new".
	 * Note que nesse caso não só é necessário que existe o parametro, mas que o valor também seja igual
	 * ao valor especificado. 
	 * Este método adiciona um novo objeto contact na lista de contatos do objeto person, esse novo contato
	 * tem a propriedade id configurada com o número de contatos existentes na lista multiplicado por -1, ou seja
	 * o número de contatos existentes na lista negativo, para que se possa identificar todos os contact, e também
	 * para que se possa identificar os que estão na base de dados e os que não estão.
	 * @param person criada e populada com os dados do form pelo Spring.
	 * @param bindingResult para certificar se o binding ocorreu corretamente.
	 * @return form é o nome da view que esta na pasta templates/form.html para o thymeleaf.
	 */
	@RequestMapping(value = "/form", method = RequestMethod.POST, params = "action=new")
	public String newContact(@ModelAttribute("person") Person person, BindingResult bindingResult,Model model) {
		Contact contact = new Contact();
		contact.setId((long) (-1 * (person.getContacts().size() + 1)));
		person.getContacts().add(contact);
		model.addAttribute("listOfPeople", personRepository.findAll());
		return "form";
	}

	/**
	 * Este Metodo esta mapeado para /from usando o método POST sem especificar nenhum parametro,
	 * ou seja,todos outros request para /form POST serão direcionados para esse método.
	 * Aqui utilizo o parametro action para pasar o id do object contact que se deseja deletar.
	 * @param person criada e populada com os dados do form pelo Spring.
	 * @param bindingResult para certificar se o binding ocorreu corretamente.
	 * @return form é o nome da view que esta na pasta templates/form.html para o thymeleaf.
	 */
	@RequestMapping(value = "/form", method = RequestMethod.POST)
	public String deleteContact(@ModelAttribute("person") Person person, BindingResult bindingResult,
			@RequestParam(value = "action", required = true) String action,Model model) {
		Long contactId = Long.parseLong(action.substring(action.lastIndexOf("_") + 1));
		Contact contactToDelete = null;
		for (Contact c : person.getContacts()) {
			if (c.getId().equals(contactId)) {
				contactToDelete = c;
				break;
			}
		}

		if (contactToDelete != null)
			person.getContacts().remove(contactToDelete);

		model.addAttribute("listOfPeople", personRepository.findAll());
		return "form";
	}

}
