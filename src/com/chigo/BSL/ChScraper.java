package com.chigo.BSL;

import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.metadata.TikaCoreProperties;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.sax.BodyContentHandler;

public class ChScraper extends Thread{
	
	//public static String Trim = getWeb().toString();
    static ChScraper webPagePdfExtractor = new ChScraper();
    public static String datePart = dater();
    public static String urlFormer1 = "https://www.bsl.gov.sl/Indicative%20Exchange%20Rate_" + datePart + ".pdf";
    
    //static Map<String, Object> extractedMap = webPagePdfExtractor.processRecord("https://www.bsl.gov.sl/Indicative%20Exchange%20Rate_26-7-18.pdf");
    //static Map<String, Object> extractedMap = webPagePdfExtractor.processRecord("https://www.bsl.gov.sl/Indicative%20Exchange%20Rate_11-9-18.pdf");
    static Map<String, Object> extractedMap = webPagePdfExtractor.processRecord(urlFormer1);
    //stem.out.println(extractedMap.get("text"));
    
    public static String REGEX2 = "\n|\r|\t";
    //public static String REGEX2 = "\n|\r|\t";
    public static String Input = extractedMap.get("text").toString();
   
    
    //public static String Input3 = extractedMap.get("title").toString();
    //public static String Input2 = (java.lang.String) extractedMap.get(" ").toString();
    //public static String[] Trim = Input.split(REGEX2);
    //public static String Trimn = Trim[0];
    //public static String cut1 = Input.substring(0, 270);
    //public static String cut2 = Input.substring(270, 2065);
    //public static String[] arr = cut2.split("\\s+");

    private volatile boolean running2 = true;
    public static String Pound1;
    public static String Pound2;
    public static String Can1;
    public static String Can2;
    public static String USD1;
	public static String USD2;
	public static String Swede1;
	public static String Swede2;
	public static String Swiss1;
	public static String Swiss2;
	public static String YEN1;
	public static String YEN2;
	public static String Nor1;
	public static String Nor2;
	public static String DAN1;
	public static String DAN2;
	public static String AUS1;
	public static String AUS2;
	public static String EUR1;
	public static String EUR2;
	public static String Saudi1;
	public static String Saudi2;
	public static String Kuwait1;
	public static String Kuwait2;
	public static String UAE1;
	public static String UAE2;
	public static String Rand1;
	public static String Rand2;
	public static String China1;
	public static String China2;
	public static String HONG1;
	public static String HONG2;
	public static String SDR1;
	public static String CFA1;
	public static String GMB1;
	public static String GUI1;
	public static String CEDI1;
	public static String NGN1;
	public static String LIB1;
	public static String CABO1;
    
	private static Date yesterday() {
	    final Calendar cal = Calendar.getInstance();
	    cal.add(Calendar.DATE, -1);
	    return cal.getTime();
	}

    public static String dater() {
    	Date date = new Date();
    	
    	DateFormat dateFormat = new SimpleDateFormat("dd-M-yy");
    	String today = dateFormat.format(date);
    	String datePT = dateFormat.format(yesterday());
    	System.out.println("()()()() ++++++++++++++++++++! "+today);
		//return datePT;
		return today;
    }
    public static String daterb() {
    	Date date = new Date();
    	
    	DateFormat dateFormat = new SimpleDateFormat("d-M-yy");
    	String today = dateFormat.format(date);
    	String datePT = dateFormat.format(yesterday());
    	System.out.println("()()()() ++++++++++++++++++++! "+today);
		//return datePT;
		return today;
    }
    
    public static String daterY() {
    	Date date = new Date();
    	
    	DateFormat dateFormat = new SimpleDateFormat("d-M-yy");
    	String today = dateFormat.format(date);
    	String datePT = dateFormat.format(yesterday());
    	System.out.println("()()()() ++++++++++++++++++++! "+dateFormat.format(yesterday()));
		return datePT;
		//return today;
    }
    
    public String getPound1() {
		return Pound1;
	}

	public static void setPound1(String pound1) {
		Pound1 = pound1;
	}

	public String getPound2() {
		return Pound2;
	}

	public static void setPound2(String pound2) {
		Pound2 = pound2;
	}

	public String getCan1() {
		return Can1;
	}

	public static void setCan1(String can1) {
		Can1 = can1;
	}

	public String getCan2() {
		return Can2;
	}

	public static void setCan2(String can2) {
		Can2 = can2;
	}

	public String getUSD1() {
		return USD1;
	}

	public static void setUSD1(String uSD1) {
		USD1 = uSD1;
	}

	public String getUSD2() {
		return USD2;
	}

	public static void setUSD2(String uSD2) {
		USD2 = uSD2;
	}

	public String getSwede1() {
		return Swede1;
	}

	public static void setSwede1(String swede1) {
		Swede1 = swede1;
	}

	public String getSwede2() {
		return Swede2;
	}

	public static void setSwede2(String swede2) {
		Swede2 = swede2;
	}

	public String getSwiss1() {
		return Swiss1;
	}

	public static void setSwiss1(String swiss1) {
		Swiss1 = swiss1;
	}

	public String getSwiss2() {
		return Swiss2;
	}

	public static void setSwiss2(String swiss2) {
		Swiss2 = swiss2;
	}

	public String getYEN1() {
		return YEN1;
	}

	public static void setYEN1(String yEN1) {
		YEN1 = yEN1;
	}

	public String getYEN2() {
		return YEN2;
	}

	public static void setYEN2(String yEN2) {
		YEN2 = yEN2;
	}

	public String getNor1() {
		return Nor1;
	}

	public static void setNor1(String nor1) {
		Nor1 = nor1;
	}

	public String getNor2() {
		return Nor2;
	}

	public static void setNor2(String nor2) {
		Nor2 = nor2;
	}

	public String getDAN1() {
		return DAN1;
	}

	public static void setDAN1(String dAN1) {
		DAN1 = dAN1;
	}

	public String getDAN2() {
		return DAN2;
	}

	public static void setDAN2(String dAN2) {
		DAN2 = dAN2;
	}

	public String getAUS1() {
		return AUS1;
	}

	public static void setAUS1(String aUS1) {
		AUS1 = aUS1;
	}

	public String getAUS2() {
		return AUS2;
	}

	public static void setAUS2(String aUS2) {
		AUS2 = aUS2;
	}

	public String getEUR1() {
		return EUR1;
	}

	public static void setEUR1(String eUR1) {
		EUR1 = eUR1;
	}

	public String getEUR2() {
		return EUR2;
	}

	public static void setEUR2(String eUR2) {
		EUR2 = eUR2;
	}

	public String getSaudi1() {
		return Saudi1;
	}

	public static void setSaudi1(String saudi1) {
		Saudi1 = saudi1;
	}

	public String getSaudi2() {
		return Saudi2;
	}

	public static void setSaudi2(String saudi2) {
		Saudi2 = saudi2;
	}

	public String getKuwait1() {
		return Kuwait1;
	}

	public static void setKuwait1(String kuwait1) {
		Kuwait1 = kuwait1;
	}

	public String getKuwait2() {
		return Kuwait2;
	}

	public static void setKuwait2(String kuwait2) {
		Kuwait2 = kuwait2;
	}

	public String getUAE1() {
		return UAE1;
	}

	public static void setUAE1(String uAE1) {
		UAE1 = uAE1;
	}

	public String getUAE2() {
		return UAE2;
	}

	public static void setUAE2(String uAE2) {
		UAE2 = uAE2;
	}

	public String getRand1() {
		return Rand1;
	}

	public static void setRand1(String rand1) {
		Rand1 = rand1;
	}

	public String getRand2() {
		return Rand2;
	}

	public static void setRand2(String rand2) {
		Rand2 = rand2;
	}

	public String getChina1() {
		return China1;
	}

	public static void setChina1(String china1) {
		China1 = china1;
	}

	public String getChina2() {
		return China2;
	}

	public static void setChina2(String china2) {
		China2 = china2;
	}

	public String getHONG1() {
		return HONG1;
	}

	public static void setHONG1(String hONG1) {
		HONG1 = hONG1;
	}

	public String getHONG2() {
		return HONG2;
	}

	public static void setHONG2(String hONG2) {
		HONG2 = hONG2;
	}

	public String getSDR1() {
		return SDR1;
	}

	public static void setSDR1(String sDR1) {
		SDR1 = sDR1;
	}

	public String getCFA1() {
		return CFA1;
	}

	public static void setCFA1(String cFA1) {
		CFA1 = cFA1;
	}

	public String getGMB1() {
		return GMB1;
	}

	public static void setGMB1(String gMB1) {
		GMB1 = gMB1;
	}

	public String getGUI1() {
		return GUI1;
	}

	public static void setGUI1(String gUI1) {
		GUI1 = gUI1;
	}

	public String getCEDI1() {
		return CEDI1;
	}

	public static void setCEDI1(String cEDI1) {
		CEDI1 = cEDI1;
	}

	public String getNGN1() {
		return NGN1;
	}

	public static void setNGN1(String nGN1) {
		NGN1 = nGN1;
	}

	public String getLIB1() {
		return LIB1;
	}

	public static void setLIB1(String lIB1) {
		LIB1 = lIB1;
	}

	public String getCABO1() {
		return CABO1;
	}

	public static void setCABO1(String cABO1) {
		CABO1 = cABO1;
	}


	public static void setCut1(String cut1) {
		//WebPagePdfExtractor.cut1 = cut1;
	}



	public static void setCut2(String cut2) {
		//WebPagePdfExtractor.cut2 = cut2;
	}
	
	public static String pound = "POUND STERLING";
	public static String canadian = "CANADIAN DOLLAR";
	public static String usdollar = "U.S. DOLLAR";
	public static String swedish = "SWEDISH KRONER";
	public static String swissfranc = "SWISS FRANC";
	public static String japanese = "JAPANESE YEN";
	public static String norweigian = "NORWEGIAN KRONE";
	public static String euro = "EURO";
	public static String danish = "DANISH KRONE";
	public static String australian = "AUSTRALIAN DOLLAR";
	public String waua = "W A U A";
	public static String saudiriyal = "SAUDI RIYAL";
	public static String kuwaitdinah = "KUWAIT DINAH";
	public static String uae = "U.A.E.DIRHAMS";
	public static String mzansi = "SOUTH AFRICAN RAND";
	public static String chineserem = "CHINESE RENMINBI";
	public static String hongkong = "HONG KONG";
	public static String sdr = "S.D.R.";
	public static String cfafranc = "CFA FRANC";
	public static String gambiandalasi ="GAMBIAN DALASI";
	public static String guinean = "GUINEAN FRANC";
	public static String cedi = "GHANABANK CEDI";
	public static String naija = "NAIRA";
	public static String liberia = "CENTRAL BANK LIBERIA";
	public static String capeverde = "CABO VERDE ESCUDOS";
	public String rimbank = "RIMBANK OUGUIYA";



	public Map<String, Object> processRecord(String url) {
		System.out.println("scraping URL:   :: " +urlFormer1);
        DefaultHttpClient httpclient = new DefaultHttpClient();
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            HttpGet httpGet = new HttpGet(url);
            HttpResponse response = httpclient.execute(httpGet);
            HttpEntity entity = response.getEntity();
            InputStream input = null;
            if (entity != null) {
                try {
                    input = entity.getContent();
                    BodyContentHandler handler = new BodyContentHandler();
                    Metadata metadata = new Metadata();
                    AutoDetectParser parser = new AutoDetectParser();
                    ParseContext parseContext = new ParseContext();
                    //parser.parse(input, handler, metadata, parseContext);
                    parser.parse(input, handler, metadata, parseContext);
                    map.put("text", handler.toString().replaceAll("\n|\r|\t", " "));
                    //map.put("text", handler.toString());
                    
                    
                    //map.put("text", handler.toString());
                    map.put("title", metadata.get(TikaCoreProperties.TITLE));
                    map.put("pageCount", metadata.get("xmpTPg:NPages"));
                    map.put("status_code", response.getStatusLine().getStatusCode() + "");
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    if (input != null) {
                        try {
                            input.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return map;
    }
	public void run() {
    	//WebPagePdfExtractor
    	
		
    	System.out.println("DATA::: "+ Input + " L : " + Input.length());
    	
    	if(Input.contains("404 (Page Not Found) Error")) {
    		System.out.println("404 Error, let's try fetching yesterday's data ");
    	   
    	    datePart = daterb();
    	    urlFormer1 = "https://www.bsl.gov.sl/Indicative%20Exchange%20Rate_" + datePart + ".pdf";
    	    
    	    
    	    extractedMap = webPagePdfExtractor.processRecord(urlFormer1);
    	    
    	    

    	    Input = extractedMap.get("text").toString();
    	    if(Input.contains("404 (Page Not Found) Error")) {
    	    	 datePart = daterY();
    	    	 urlFormer1 = "https://www.bsl.gov.sl/Indicative%20Exchange%20Rate_" + datePart + ".pdf";
    	    	    
    	    	    
    	    	 extractedMap = webPagePdfExtractor.processRecord(urlFormer1);
    	    	    
    	    	    

    	    	 Input = extractedMap.get("text").toString();
    	    
    	    }
    		
    		
    	}
    	
    	
    	
    	
    	//grabTwo();
    	//Setters for only BID and ASK currencies
    	//while(running2) {
    	try {
    	setPound1(grabOne(pound)[0]);
    	setPound2(grabOne(pound)[1]);
    	setCan1(grabOne(canadian)[0]);
    	setCan2(grabOne(canadian)[1]);
    	setUSD1(grabOne(usdollar)[0]);
    	setUSD2(grabOne(usdollar)[1]);
    	setSwede1(grabOne(swedish)[0]);
    	setSwede2(grabOne(swedish)[1]);
    	setSwiss1(grabOne(swissfranc)[0]);
    	setSwiss2(grabOne(swissfranc)[1]);
    	setYEN1(grabOne(japanese)[0]);
    	setYEN2(grabOne(japanese)[1]);
    	setNor1(grabOne(norweigian)[0]);
    	setNor2(grabOne(norweigian)[1]);
    	setDAN1(grabOne(danish)[0]);
    	setDAN2(grabOne(danish)[1]);
    	setAUS1(grabOne(australian)[0]);
    	setAUS2(grabOne(australian)[1]);
    	setEUR1(grabOne(euro)[0]);
    	setEUR2(grabOne(euro)[1]);
    	//setEUR1(grabOne2(euro).get(0).toString());
    	//setEUR2(grabOne2(euro).get(1).toString());
    	setSaudi1(grabOne(saudiriyal)[0]);
    	setSaudi2(grabOne(saudiriyal)[1]);
    	setKuwait1(grabOne(kuwaitdinah)[0]);
    	setKuwait2(grabOne(kuwaitdinah)[0]);
    	setUAE1(grabOne(uae)[0]);
    	setUAE2(grabOne(uae)[1]);
    	setRand1(grabOne(mzansi)[0]);
    	setRand2(grabOne(mzansi)[1]);
    	setChina1(grabOne(chineserem)[0]);
    	setChina2(grabOne(chineserem)[1]);
    	setHONG1(grabOne(hongkong)[0]);
    	setHONG2(grabOne(hongkong)[1]);
    	
    	
    	
    	
    	//Setters for only BID currencies
    	setNGN1(grabSingle(naija)[0]);
    	setSDR1(grabSingle(sdr)[0]);
    	setCFA1(grabSingle(cfafranc)[0]);
    	setGMB1(grabSingle(gambiandalasi)[0]);
    	setGUI1(grabSingle(guinean)[0]);
    	setCEDI1(grabSingle(cedi)[0]);
    	setLIB1(grabSingle(liberia)[0]);
    	setCABO1(grabSingle(capeverde)[0]);
    	
    	
    	System.out.println("POUND! _____-----) " + Pound1 + "Pound2 " + Pound2 + " " + Can1 + "Naira : " + NGN1);
    	//grabOne(pound);
    	}catch(Exception e2) {
    		System.out.println("Only thing I could get was.. " + Input);
    		//datePart = daterY();
    	}
		}
	

	public void end() {
		System.out.println("end this");
		running2 = false;
	}


	public static List grabOne2(String currencyName) {
		String string = "(?<=" + currencyName + ").*";

	
		//Pattern pattern = Pattern.compile("(?<=currencyName).*");
		Pattern pattern = Pattern.compile(string);
    	//Pattern pattern = Pattern.compile("(?<=DANISH KRONE|word|(DANISH KRONE){1,4}).*");
    	Matcher matcher = pattern.matcher(Input);
    	String[] splitPT;
    	
    	//boolean found = false;
    	//while (matcher.find())
    	//{
    	    matcher.find();
    	    System.out.println("Grabbed something " + matcher.group().toString());
    	    String firstPT = matcher.group().toString();
    	    String secondPT = firstPT.substring(0, 29).trim();
    	    String thirdPT = secondPT.replaceAll(",", "");
    	    String fourtPT = thirdPT.replaceAll("\\s", ",");
    	    System.out.println("third part >> " + fourtPT);
    	    splitPT = fourtPT.split(",");
    	    
    	    List<String> values = new ArrayList<String>();
    	      for(String data: splitPT) {
    	         if(data != " ") {
    	            values.add(data);
    	         }
    	      }
    	      String[] target = values.toArray(new String[values.size()]);
    	      values.removeAll(Arrays.asList("", null));
    	      
    	      
    	    

    	    System.out.println("EURO SPLITTING!  " + values.get(0) + " L " + " Second:  " + values.get(1) + " length" +splitPT.length);
    	    System.out.println("Second part here> " + secondPT);
    	    
    	    //found = true;
    	    
    	    return values;
   
    	
	}

	public static String[] grabOne(String currencyName) {
		String string = "(?<=" + currencyName + ").*";

	
		//Pattern pattern = Pattern.compile("(?<=currencyName).*");
		Pattern pattern = Pattern.compile(string);
    	//Pattern pattern = Pattern.compile("(?<=DANISH KRONE|word|(DANISH KRONE){1,4}).*");
    	Matcher matcher = pattern.matcher(Input);
    	String[] splitPT;
    	
    	//boolean found = false;
    	//while (matcher.find())
    	//{
    	    matcher.find();
    	    System.out.println("Grabbed something " + matcher.group().toString());
    	    String firstPT = matcher.group().toString();
    	    String secondPT = firstPT.substring(0, 29).trim().replaceAll(" +", " ");
    	    String thirdPT = secondPT.replaceAll(",", "");
    	    String fourtPT = thirdPT.replaceAll("\\s", ",");
    	    System.out.println("third part >> " + fourtPT);
    	    splitPT = fourtPT.split(",");
    
    	    System.out.println("SPLITTING!  " + splitPT[0] + " L " + " Second:  " + splitPT[1] + splitPT.length);
    	    System.out.println("Second part here> " + secondPT);
    	    
    	    //found = true;
    	    
    	    return splitPT;
    	//}
    	
    	//if (!found)
    	//{
    	    //System.out.println("I Couldn't Grab anything ");
    	    
    	//}
    	//return splitPT;
		
    	
	}
	public static String[] grabSingle(String currencyName) {
		String string = "(?<=" + currencyName + ").*";

	
		//Pattern pattern = Pattern.compile("(?<=currencyName).*");
		Pattern pattern = Pattern.compile(string);
    	//Pattern pattern = Pattern.compile("(?<=DANISH KRONE|word|(DANISH KRONE){1,4}).*");
    	Matcher matcher = pattern.matcher(Input);
    	String[] splitPT;
    	
    	//boolean found = false;
    	//while (matcher.find())
    	//{
    	    matcher.find();
    	    System.out.println("Grabbed something " + matcher.group().toString());
    	    String firstPT = matcher.group().toString();
    	    String secondPT = firstPT.substring(0, 10).trim();
    	    String thirdPT = secondPT.replaceAll(",", "");
    	    String fourtPT = thirdPT.replaceAll("\\s", ",");
    	    System.out.println("third part >> " + fourtPT);
    	    splitPT = fourtPT.split(",");
    	    //System.out.println("SPLITTING!  " + splitPT[0] + " L " + splitPT.length);
    	    //System.out.println("Second part here> " + secondPT);
    	    
    	    //found = true;
    	    
    	    return splitPT;
    	//}
    	
    	//if (!found)
    	//{
    	    //System.out.println("I Couldn't Grab anything ");
    	    
    	//}
    	//return splitPT;
		
    	
	}
	
	
	public static void grabTwo() {
		Pattern pattern = Pattern.compile("(?<=GUINEAN FRANC).*");

    	//Pattern pattern = Pattern.compile("(?<=DANISH KRONE|word|(DANISH KRONE){1,4}).*");
    	Matcher matcher = pattern.matcher(Input);
    	
    	boolean found = false;
    	while (matcher.find())
    	{
    	    System.out.println("Grabbed something " + matcher.group().toString());
    	    String firstPT = matcher.group().toString();
    	    String secondPT = firstPT.substring(0, 10).trim();
    	    String thirdPT = secondPT.replaceAll(",", "");
    	    String fourtPT = thirdPT.replaceAll("\\s", ",");
    	    System.out.println("third part >> " + fourtPT);
    	    String[] splitPT = fourtPT.split(",");
    	    System.out.println("SPLITTING!  " + splitPT[0] + " L " + splitPT.length);
    	    System.out.println("Second part here> " + secondPT);
    	    found = true;
    	}
    	if (!found)
    	{
    	    System.out.println("I Couldn't Grab anything ");
    	}
	}
	
	
	
	
	

    
    


    



}