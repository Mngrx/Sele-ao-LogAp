package br.com.logap.eolica.resources;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import springfox.documentation.annotations.ApiIgnore;

@ApiIgnore
@RestController
public class EolicaRedirectResources {
	

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public RedirectView redirecionamentoParaSwagger() {
		
		RedirectView redirectView = new RedirectView();
	    redirectView.setUrl("/swagger-ui.html");
	    return redirectView;
		
	}
	
}
