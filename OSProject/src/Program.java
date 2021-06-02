import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Program {
	static ArrayList<Variable> variables = new ArrayList<Variable>();

	public static ArrayList<String[]> readFile(String filePath) throws FileNotFoundException {
		File myObj = new File(filePath);
		Scanner myReader = new Scanner(myObj);
		ArrayList<String[]> program = new ArrayList<String[]>();
		while (myReader.hasNextLine()) {
			String data = myReader.nextLine();
			String[] Line = data.split(" ");
			program.add(Line);
			// System.out.println(data);
		}
		return program;
	}

	public static String input() {
		Scanner sc = new Scanner(System.in);
		String inp = sc.nextLine();
		// sc.close();
		return inp;
	}

	public static String checkIfVar(ArrayList<Variable> variables, String target) {
		for (Variable x : variables) {
			if (x.name.equals(target))
				return (String) x.value;
		}
		return target;
	}

	public static boolean isNumber(String s) {
		try {
			Integer.parseInt(s);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public static void interpreter(String filePath) throws FileNotFoundException {
		ArrayList<String[]> program = readFile(filePath);
		Stack<Object> code = new Stack<Object>();

		for (int i = 0; i < program.size(); i++) {
			for (int j = program.get(i).length - 1; j >= 0 || code.size() != 0; j--) {

				switch (program.get(i)[j]) {

				case "print":
					try {
						String printed = checkIfVar(variables, (String) code.pop());
						System.out.println(printed);
					} catch (Exception e) {
						System.out.println("/*   Error While Printing   */");
					}
					break;

				case "assign":
					try {
						boolean flag = false;
						String var = code.pop() + "";
						String value = (String) code.pop();
						if (isNumber(var)) {
							System.out.println("Variable can't be a number ");
							System.exit(-1);
						}
						if (value.equals("input"))
							value = input();
						else
							value = checkIfVar(variables, value);
						for (Variable x : variables)
							if (x.name.equals(var)) {
								x.value = value;
								flag = true;
								break;
							}
						if (!flag)
							variables.add(new Variable(var, value));
					}
					catch (Exception e) {
						System.out.println("/*    Error While Assigning   */");
						System.exit(-1);
					}
					break;

				case "add":
					try {
						String firstVar = (String) code.pop();
						if (isNumber(firstVar)) {
							System.out.println("Variable can't be a number ");
							System.exit(-1);
						}
						int firstDigit = Integer.parseInt(checkIfVar(variables, firstVar));
						String secondVar = (String) code.pop();
						int secondDigit = 0;
						if (secondVar.equals("input"))
							secondDigit = Integer.parseInt(input());
						else
							secondDigit = Integer.parseInt(checkIfVar(variables, secondVar));
						int sum = firstDigit + secondDigit;
						for (Variable x : variables)
							if (x.name.equals(firstVar))
								x.value = sum + "";
					} catch (Exception e) {
						System.out.println("Something wrong with the addition");
						System.exit(-1);
					}
					break;

				case "writeFile":
					try {
						String fileName = checkIfVar(variables, (String) code.pop()) + ".txt";
						String data = checkIfVar(variables, (String) code.pop());
						File myFile = new File(fileName);
						myFile.createNewFile();
						FileWriter myWrite = new FileWriter(fileName);
						myWrite.write(data);
						myWrite.close();
					} catch (Exception e) {
						System.out.println("An error occurred while writing");
						System.exit(-1);
						e.printStackTrace();
					}
					break;

				case "readFile":
					String fileName = (String) code.pop();
					fileName = checkIfVar(variables, fileName) + ".txt";
					try {
						String text = new String(Files.readAllBytes(Paths.get(fileName)), StandardCharsets.UTF_8);
						code.push(text);
					} catch (IOException e) {
						System.out.println("/*   There is No Such a File   */");
						System.exit(-1);
						e.printStackTrace();
					}
					break;

				default:
					code.push(program.get(i)[j]);
				}

			}

		}

	}

	public static void main(String[] args) throws IOException {
		// readFile("hamada.txt");
		interpreter("Program 1.txt");
		interpreter("Program 2.txt");
		interpreter("Program 3.txt");
//		Object x = 5;
//		System.out.println(x.getClass());
	}
}
