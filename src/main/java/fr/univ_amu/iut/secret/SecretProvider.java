package fr.univ_amu.iut.secret;


/*
SecretProvider : API permettant de vérifier si le mot de passe entré est le bon
Nous avons fait une interface afin de pouvoir créer facilement d'autres implémentations dans le futur
(comme par exemple une implémentation faisant une requête web pour vérifier le mot de passe auprès d'un serveur)
 */
public interface SecretProvider {

	static SecretProvider getInstance(){
		return new LocalSecretProvider();
	}

	boolean isSecretValid(String secret);
}
