
public class kanjiToArabic {
		/** 文字列の中は、すべて漢数字であること。 */
		int convert(String str) {
			int ひと桁 = 1;
			int 四桁 = 0;
			int 答え = 0;
			for (int i=0; i<str.length(); i++) {
				switch (str.charAt(i)) {
				case '一':	ひと桁 = 1;	break;
				case '二':	ひと桁 = 2;	break;
				case '三':	ひと桁 = 3;	break;
				case '四':	ひと桁 = 4;	break;
				case '五':	ひと桁 = 5;	break;
				case '六':	ひと桁 = 6;	break;
				case '七':	ひと桁 = 7;	break;
				case '八':	ひと桁 = 8;	break;
				case '九':	ひと桁 = 9;	break;
				case '十':	四桁 += (ひと桁!=0?ひと桁:1) * 10;	ひと桁 = 0;	break;
				case '百':	四桁 += (ひと桁!=0?ひと桁:1) * 100;	ひと桁 = 0;	break;
				case '千':	四桁 += (ひと桁!=0?ひと桁:1) * 1000;	ひと桁 = 0;	break;
				case '万':	答え += (四桁!=0?四桁:1)*10000; 四桁 = 0;	ひと桁 = 0;	break;
				case '億':	答え += (四桁!=0?四桁:1)*100000000; 四桁 = 0;	ひと桁 = 0;	break;
				default:	System.out.println("??? "+str.charAt(i));
				}
			}
			return 答え + 四桁 + ひと桁;
		}

		public static void main(String[] args) {
			kanjiToArabic text = new kanjiToArabic();
			System.out.println(text.convert("三"));
			System.out.println(text.convert("二千五百"));
			System.out.println(text.convert("三千"));
			System.out.println(text.convert("一億五千万"));
			System.out.println(text.convert("一億五千万四"));
			System.out.println(text.convert("千十一"));
//			String test = "フランス料理のコース二千五百円(サービス料金加えて三千円)三名様より";

		}
}
