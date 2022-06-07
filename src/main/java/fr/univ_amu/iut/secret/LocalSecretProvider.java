package fr.univ_amu.iut.secret;

import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;

public class LocalSecretProvider implements SecretProvider {

	// Le mot de passe est "azerty"
	private final static String ARGON_HASH = "$argon2id$v=19$m=16,t=2,p=1$Tms1dkJYWEZ5OTdJTndVTg$+iBsHiILEshy1JLZsTfZFQ";
	private final static Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);


	@Override
	public boolean isSecretValid(String secret) {
		return argon2.verify(ARGON_HASH, secret.getBytes());
	}
}
