package lambdas;
/*
 * () -> {}
 */
public class LambdaBasics {
	public static void main(String[] args) {
		LambdaInterface lambda = () -> {
			return "Hello World";
		};
		
		String output  = lambda.helloWorld();
		System.out.println(output);
	}
}
