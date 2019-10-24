

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class FileUser {
	//空文字が入る限り正しい入力を要求するメソッド
	public static String checkInput(String input) {
		while(true) {
			if(!input.equals("")) {
				break;
			}
			Main.divider();
			System.out.println("入力は無効です。再度入力してください");
			input = Display.input();
		}
		return input;
	}
	public static void exportText(String dir, String fileName,  ArrayList<String> textArray) {
        try {
            FileWriter fw = new FileWriter(dir + fileName);
            for(String text : textArray) {
                fw.write(text);
            }
            fw.close();
        } catch (IOException ex) {
        	System.out.println("書き込み時に問題が発生しました");
            ex.printStackTrace();
        }
    }
	public static ArrayList<String> textToArrayList(String pathName)throws FileNotFoundException {
		try {
			// 1.ファイルのパスを指定する
			File file = new File(pathName);

			// 2.ファイルが存在しない場合
			if (!file.exists()) {
				System.out.print("ファイルが存在しません。パスを再入力してください\n");
				Main.divider();
				System.out.println(Sentence.initImport);//再入力させ再度読み込み
				pathName = Display.input();
				textToArrayList(pathName);
			}
			// 3.FileReaderクラスとreadメソッドを使って1文字ずつ読み込み表示する
			FileReader fr = new FileReader(pathName);
			BufferedReader br = new BufferedReader(fr);
			ArrayList<String> strArray = new ArrayList<>();
			String str = "";
			while ((str = br.readLine()) != null) {
				strArray.add(str + "\n");//ArrayList<String>も用意
			}
			fr.close();
			return strArray;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static String textToString(String pathName)throws FileNotFoundException {
		try {
			// 1.ファイルのパスを指定する
			File file = new File(pathName);

			// 2.ファイルが存在しない場合
			if (!file.exists()) {
				System.out.print("ファイルが存在しません。パスを再入力してください\n");
				Main.divider();
				System.out.println(Sentence.initImport);//再入力させ再度読み込み
				pathName = Display.input();
				textToString(pathName);
			}
			// 3.FileReaderクラスとreadメソッドを使って1文字ずつ読み込み表示する
			FileReader fr = new FileReader(pathName);
			BufferedReader br = new BufferedReader(fr);
			String str = "";
			String text = "";
			while ((str = br.readLine()) != null) {
				text += str;
			}
			fr.close();
			return text;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	public String[] splitText(String text, String splitWord) throws IOException{
		String[] str = text.split(splitWord);
		return str;
	}

	public void domRead(String file) throws SAXException, IOException, ParserConfigurationException {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder documentBuilder = factory.newDocumentBuilder();
		Document document = documentBuilder.parse(file);

		Element root = document.getDocumentElement();

		//ルート要素のノード名を取得する
		System.out.println("ノード名：" +root.getNodeName());

		//ルート要素の属性を取得する
		System.out.println("ルート要素の属性：" + root.getAttribute("name"));

		//ルート要素の子ノードを取得する
		NodeList rootChildren = root.getChildNodes();

		System.out.println("子要素の数：" + rootChildren.getLength());
		System.out.println("------------------");

		for(int i=0; i < rootChildren.getLength(); i++) {
			Node node = rootChildren.item(i);

			if (node.getNodeType() == Node.ELEMENT_NODE) {
				Element element = (Element)node;
				if (element.getNodeName().equals("person")) {
					System.out.println("名前：" + element.getAttribute("name"));
					NodeList personChildren = node.getChildNodes();

					for (int j=0; j < personChildren.getLength(); j++) {
						Node personNode = personChildren.item(j);
						if (personNode.getNodeType() == Node.ELEMENT_NODE) {

							if (personNode.getNodeName().equals("age")) {
								System.out.println("年齢：" + personNode.getTextContent());
							} else if (personNode.getNodeName().equals("interest")) {
								System.out.println("趣味:" + personNode.getTextContent());
							}

						}
					}
					System.out.println("------------------");
				}
			}


		}


	}
}