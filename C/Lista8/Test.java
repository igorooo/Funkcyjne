public class Test {
	int zawarto�� = 0;	// przechowywane na stercie
	
	/* Podczas gdy "zmienna" jest referencj� do obiektu przekazywanego do metody
	 * i nie mo�e zacz�� wskazywac na inny obiekt, to zawarto�� tego obiektu mo�e
	 * ulec zmianie. Tyczy s� to obiekt�w finalnych jak i zwyk�ych. */
	static void argNiemodyfikowalny(final Test zmienna) {
		zmienna.zawarto�� = 1;
		// zmienna = null;	// Nie mo�na zmieni� referencji obiektu final
	}
	
	/* Argument przekazany jest przez referencj� co oznacza �e "zmienna" jest
	 * tylko referencj� do obiektu i przypisywanie jest warto�ci null spowoduje,
	 * �e nie b�dzie wskazywa�a ju� na ten obiekt, natiomiast sam obiekt w tym
	 * momencie pozostanie w pami�ci */
	static void argModyfikowalny(Test zmienna) {
		zmienna.zawarto�� = 1;
		zmienna = null;
	}
	
	public static void main(String[] args) {
		// przechowywane na stosie s� referencje (nie)modyfikowalna
		// przechowywane na stercie s� obiekty Test()
		Test modyfikowalna = new Test();
		final Test niemodyfikowalna = new Test();
		
		argNiemodyfikowalny(modyfikowalna);
		System.out.println(modyfikowalna.zawarto��);	// 1
		
		argNiemodyfikowalny(niemodyfikowalna);
		System.out.println(niemodyfikowalna.zawarto��);	// 1
		
		argModyfikowalny(modyfikowalna);
		System.out.println(modyfikowalna.zawarto��);	// 1
		
		argModyfikowalny(niemodyfikowalna);
		System.out.println(niemodyfikowalna.zawarto��);	// 1
	}
}