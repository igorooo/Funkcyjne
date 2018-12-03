public class Test {
	int zawartoœæ = 0;	// przechowywane na stercie
	
	/* Podczas gdy "zmienna" jest referencj¹ do obiektu przekazywanego do metody
	 * i nie mo¿e zacz¹æ wskazywac na inny obiekt, to zawartoœæ tego obiektu mo¿e
	 * ulec zmianie. Tyczy sê to obiektów finalnych jak i zwyk³ych. */
	static void argNiemodyfikowalny(final Test zmienna) {
		zmienna.zawartoœæ = 1;
		// zmienna = null;	// Nie mo¿na zmieniæ referencji obiektu final
	}
	
	/* Argument przekazany jest przez referencjê co oznacza ¿e "zmienna" jest
	 * tylko referencj¹ do obiektu i przypisywanie jest wartoœci null spowoduje,
	 * ¿e nie bêdzie wskazywa³a ju¿ na ten obiekt, natiomiast sam obiekt w tym
	 * momencie pozostanie w pamiêci */
	static void argModyfikowalny(Test zmienna) {
		zmienna.zawartoœæ = 1;
		zmienna = null;
	}
	
	public static void main(String[] args) {
		// przechowywane na stosie s¹ referencje (nie)modyfikowalna
		// przechowywane na stercie s¹ obiekty Test()
		Test modyfikowalna = new Test();
		final Test niemodyfikowalna = new Test();
		
		argNiemodyfikowalny(modyfikowalna);
		System.out.println(modyfikowalna.zawartoœæ);	// 1
		
		argNiemodyfikowalny(niemodyfikowalna);
		System.out.println(niemodyfikowalna.zawartoœæ);	// 1
		
		argModyfikowalny(modyfikowalna);
		System.out.println(modyfikowalna.zawartoœæ);	// 1
		
		argModyfikowalny(niemodyfikowalna);
		System.out.println(niemodyfikowalna.zawartoœæ);	// 1
	}
}