package fr.univ_amu.iut.secret;

public interface SecretProvider {

	static SecretProvider getInstance(){
		return new LocalSecretProvider();
	}

	boolean isSecretValid(String secret);
}
