package com.paysecure.bcc.util;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;

import javax.faces.FactoryFinder;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;
import javax.faces.context.FacesContextFactory;
import javax.faces.convert.Converter;
import javax.faces.lifecycle.Lifecycle;
import javax.faces.lifecycle.LifecycleFactory;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class JsfUtil {

	public static String recuperarContextoApp() {
		return FacesContext.getCurrentInstance().getExternalContext()
				.getRequestContextPath();
	}

	public static void redirecionarUsuario(String pagina) {
		try {
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect(recuperarContextoApp() + pagina);
			FacesContext.getCurrentInstance().responseComplete();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void addMsgGrowlSucesso(String mensagem, String detalhes) {
		FacesContext ctx = FacesContext.getCurrentInstance();
		ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
				mensagem, null));
		if (detalhes != null) {
			ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
					detalhes, null));
		}
	}

	public static void addMsgGrowlError(String mensagem, String detalhes) {
		FacesContext ctx = FacesContext.getCurrentInstance();
		ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
				mensagem, null));
		if (detalhes != null) {
			ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					detalhes, null));
		}
	}

	public static void addMsgGrowlWarning(String mensagem, String detalhes) {
		FacesContext ctx = FacesContext.getCurrentInstance();
		ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
				mensagem, null));
		if (detalhes != null) {
			ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
					detalhes, null));
		}
	}

	public static void addErrorMessageExcecao(Exception ex, String defaultMsg) {
		String msg = ex.getLocalizedMessage();

		if ((msg != null) && (msg.length() > 0)) {
			addErrorMessage(null, msg);
		} else {
			addErrorMessage(null, defaultMsg);
		}
	}

	public static void addErrorMessages(List<String> messages) {
		for (String message : messages) {
			addErrorMessage(null, message);
		}
	}

	public static void addErrorMessage(String idComponente, String msg) {
		FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
				msg, msg);
		FacesContext.getCurrentInstance().addMessage(idComponente, facesMsg);
	}

	public static void addSuccessMessage(String idComponente, String msg) {
		FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_INFO,
				msg, msg);
		FacesContext.getCurrentInstance().addMessage("idComponente", facesMsg);
	}

	public static String getRequestParameter(String key) {
		return FacesContext.getCurrentInstance().getExternalContext()
				.getRequestParameterMap().get(key);
	}

	public static Object getObjectFromRequestParameter(
			String requestParameterName, Converter converter,
			UIComponent component) {
		String theId = JsfUtil.getRequestParameter(requestParameterName);
		return converter.getAsObject(FacesContext.getCurrentInstance(),
				component, theId);
	}

	public static Object getMethod(Object obj, String name) throws Exception {
		Method createMethod = obj.getClass().getMethod(name, new Class[0]);
		return createMethod.invoke(obj, new Object[0]);
	}

	public static void setAttribute(String valorObjeto, Object tipoObjeto) {
		FacesContext.getCurrentInstance().getExternalContext().getRequestMap()
				.put(valorObjeto, tipoObjeto);
	}

	public static Object getAttribute(String valorObjeto) {
		return FacesContext.getCurrentInstance().getExternalContext()
				.getRequestMap().get(valorObjeto);
	}
	
	public static FacesContext getFacesContext(HttpServletRequest request,
			HttpServletResponse response) {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		if (facesContext == null) {

			FacesContextFactory contextFactory = (FacesContextFactory) FactoryFinder
					.getFactory(FactoryFinder.FACES_CONTEXT_FACTORY);
			LifecycleFactory lifecycleFactory = (LifecycleFactory) FactoryFinder
					.getFactory(FactoryFinder.LIFECYCLE_FACTORY);
			Lifecycle lifecycle = lifecycleFactory
					.getLifecycle(LifecycleFactory.DEFAULT_LIFECYCLE);

			facesContext = contextFactory.getFacesContext(request.getSession()
					.getServletContext(), request, response, lifecycle);

			// set a new viewRoot, otherwise context.getViewRoot returns null
			UIViewRoot view = facesContext.getApplication().getViewHandler()
					.createView(facesContext, "");
			facesContext.setViewRoot(view);
		}
		return facesContext;
	}

	public static String pathArquivo(String fileName) {
		FacesContext ctx = FacesContext.getCurrentInstance();
		HttpServletRequest request = (HttpServletRequest) ctx
				.getExternalContext().getRequest();
		// Observe que o arquivo index.html est� na raiz da aplica��o. Pego o
		// diret�rio a partir dele
		String caminho = request.getRealPath("/index.html");
		int index = caminho.lastIndexOf("/");
		caminho = caminho.substring(0, ++index);
		return caminho + fileName;
	}
	
	public static boolean isWindows(){
		if(System.getProperty("os.name").contains("Windows")){
			return true;
		}else{
			return false;
		}
	}
}
