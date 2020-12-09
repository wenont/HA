/**
 * Schreibe eine Kalendar
 */
public class Launcher {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
  Product a=new Product("Apfel",BooleanStringHelper.parse("111111001111",'1'),BooleanStringHelper.parse("111111111111",'1' ));
  Product b=new Product("Banane",BooleanStringHelper.parse("000000000000",'1'),BooleanStringHelper.parse("111111111111",'1' ));
  Product c=new Product("Erdbeere",BooleanStringHelper.parse("000011100000",'1'),BooleanStringHelper.parse("000110000000",'1' ));
  Product d=new Product("Blumenkohl",BooleanStringHelper.parse("000001111100",'1'),BooleanStringHelper.parse("111100000011",'1' ));
  Product e=new Product("Feldsalat",BooleanStringHelper.parse("100011001111",'1'),BooleanStringHelper.parse("111100001111",'1' ));
  Product f=new Product("Zwiebel",BooleanStringHelper.parse("111110011111",'1'),BooleanStringHelper.parse("001111100000",'1' ));
  Product[] products= {a,b,c,d,e,f}; 

  SeasonalCalendar outputCalendar =new SeasonalCalendar(products);
	System.out.print(outputCalendar.stringify());
	
	}
}
