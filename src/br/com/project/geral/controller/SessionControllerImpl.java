package br.com.project.geral.controller;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

public class SessionControllerImpl implements SessionController {

	private static final long serialVersionUID = 1L;

	private HashMap<String, HttpSession> hasMap = new HashMap<String, HttpSession>();

	@Override
	public void add(String keyLoginUser, HttpSession httpSession) {
		hasMap.put(keyLoginUser, httpSession);
	}

	@Override
	public void invalidateSession(String keyLoginUser) {

		HttpSession session = hasMap.get(keyLoginUser);

		if (session != null) { // Remove sessão do usuario passado como parametros

			try {
				session.invalidate();
			} catch (Exception e) {
				e.printStackTrace();
			}

		} else {
			System.out.println("Não tem usuário");
		}

		hasMap.remove(keyLoginUser);

	}
}