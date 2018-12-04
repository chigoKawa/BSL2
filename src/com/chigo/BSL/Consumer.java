// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Consumer.java

package com.chigo.BSL;

import com.thomsonreuters.ema.access.*;
import com.thomsonreuters.platformservices.elektron.objects.data.Field;
import java.io.PrintStream;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.chigo.BSL:
//            ChScraper, AppClient, MarketPrice

public class Consumer extends ChScraper
    implements Runnable
{

    public Consumer()
    {
        running = true;
        consumer = null;
    }

    public void stop4()
    {
        System.out.println("Stop if running");
        shutdown();
        consumer.uninitialize();
    }

    public void run()
    {
        System.out.println("Starting consumer");
        try
        {
            ChScraper ch = new ChScraper();
            shutup();
            ch.start();
            AppClient appClient = new AppClient();
            consumer = EmaFactory.createOmmConsumer(EmaFactory.createOmmConsumerConfig().host("10.3.20.206:14002").username("chigozirim.kawa"));
            ElementList view = EmaFactory.createElementList();
            OmmArray array = EmaFactory.createOmmArray();
            array.fixedWidth(2);
            array.add(EmaFactory.createOmmArrayEntry().intValue(393L));
            array.add(EmaFactory.createOmmArrayEntry().intValue(275L));
            view.add(EmaFactory.createElementEntry().uintValue(":ViewType", 1L));
            view.add(EmaFactory.createElementEntry().array(":ViewData", array));
            long loginHandle = consumer.registerClient(EmaFactory.createReqMsg().serviceName("EIKON").name("GBPSLLFIX="), appClient);
            System.out.println("calling market price");
            VPound1 = subscribeBID(consumer, RPound1);
            VCan1 = subscribeBID(consumer, RCan1);
            VUSD1 = subscribeBID(consumer, RUSD1);
            VSwede1 = subscribeBID(consumer, RSwede1);
            VSwiss1 = subscribeBID(consumer, RSwiss1);
            VYEN1 = subscribeBID(consumer, RYEN1);
            VNor1 = subscribeBID(consumer, RNor1);
            VEUR1 = subscribeBID(consumer, REUR1);
            VDAN1 = subscribeBID(consumer, RDAN1);
            VAUS1 = subscribeBID(consumer, RAUS1);
            VSaudi1 = subscribeBID(consumer, RSaudi1);
            VKuwait1 = subscribeBID(consumer, RKuwait1);
            VUAE1 = subscribeBID(consumer, RUAE1);
            VRand1 = subscribeBID(consumer, RRand1);
            VChina1 = subscribeBID(consumer, RChina1);
            VHONG1 = subscribeBID(consumer, RHONG1);
            VSDR1 = subscribeBID(consumer, RSDR1);
            VCFA1 = subscribeBID(consumer, RCFA1);
            VGMB1 = subscribeBID(consumer, RGMB1);
            VGUI1 = subscribeBID(consumer, RGUI1);
            VCEDI1 = subscribeBID(consumer, RCEDI1);
            VNGN1 = subscribeBID(consumer, RNGN1);
            VLIB1 = subscribeBID(consumer, RLIB1);
            VCABO1 = subscribeBID(consumer, RCABO1);
            consumer.unregister(loginHandle);
            double mCan1 = makeDouble(Can1);
            double mPound1 = makeDouble(Pound1);
            poster2(Pound1, Pound2, VPound1, RPound1);
            poster2(Can1, Can2, VCan1, RCan1);
            poster2(USD1, USD2, VUSD1, RUSD1);
            poster2(Swede1, Swede2, VSwede1, RSwede1);
            poster2(Swiss1, Swiss2, VSwiss1, RSwiss1);
            poster2(YEN1, YEN2, VYEN1, RYEN1);
            poster2(Nor1, Nor2, VNor1, RNor1);
            poster2(EUR1, EUR2, VEUR1, REUR1);
            poster2(DAN1, DAN2, VDAN1, RDAN1);
            poster2(AUS1, AUS2, VAUS1, RAUS1);
            poster2(Saudi1, Saudi2, VSaudi1, RSaudi1);
            poster2(Kuwait1, Kuwait2, VKuwait1, RKuwait1);
            poster2(UAE1, UAE2, VUAE1, RUAE1);
            poster2(Rand1, Rand2, VRand1, RRand1);
            poster2(China1, China2, VChina1, RChina1);
            poster2(HONG1, HONG2, VHONG1, RHONG1);
            AppClient appClient2 = new AppClient();
            ReqMsg reqMsg = EmaFactory.createReqMsg();
            OmmConsumer consumer3 = EmaFactory.createOmmConsumer(EmaFactory.createOmmConsumerConfig().host("10.3.20.206:14002").host("10.3.20.206:14002").username("chigozirim.kawa"));
            long loginHandle2 = consumer3.registerClient(reqMsg.domainType(1), appClient2, consumer2);
            poster(SDR1, VSDR1, RSDR1);
            poster(CFA1, VCFA1, RCFA1);
            poster(GMB1, VGMB1, RGMB1);
            poster(GUI1, VGUI1, RGUI1);
            poster(CEDI1, VCEDI1, RCEDI1);
            poster(NGN1, VNGN1, RNGN1);
            poster(LIB1, VLIB1, RLIB1);
            poster(CABO1, VCABO1, RCABO1);
            running = false;
            ch.end();
            System.out.println("ALL posts sent!");
            System.out.println("THE END!!!!!! ");
            consumer.uninitialize();
            consumer2.uninitialize();
            System.out.println((new StringBuilder("VPound1 : ")).append(VPound1).append("mPound1 : ").append(mPound1).toString());
            if(VPound1 != mPound1)
                System.out.println((new StringBuilder(String.valueOf(VPound1))).append(" : is not same as : ").append(mPound1).toString());
            Thread.sleep(100L);
            consumer.uninitialize();
            System.out.println("ENDING PROGRAM");
            System.exit(0);
            //break MISSING_BLOCK_LABEL_1121;
        }
        catch(Exception excp)
        {
            System.out.println(excp.getMessage());
        }
        if(consumer != null)
            consumer.uninitialize();
        //break MISSING_BLOCK_LABEL_1137;
        //Exception exception;
        //exception;
        if(consumer != null)
            consumer.uninitialize();
        //throw exception e;
        if(consumer != null)
            consumer.uninitialize();
    }

    public void shutdown()
    {
        System.out.println("shuting down..");
        running = false;
    }

    public void shutup()
    {
        System.out.println("shuting down..");
        try
        {
            TimeUnit.SECONDS.sleep(20L);
        }
        catch(InterruptedException e)
        {
            e.printStackTrace();
        }
        running = true;
    }

    public static double makeDouble(String fromScraper)
    {
        double mPound1 = 0.0D;
        try
        {
            mPound1 = Double.parseDouble(fromScraper);
        }
        catch(Exception eb)
        {
            eb.getMessage();
            System.out.println("BID is blank at this point, no rate for today on website!");
        }
        return mPound1;
    }

    public static void poster(String mainBid, double eikonBid, String RIC)
    {
        System.out.println("Posting from poster, for only bid currencies");
        double mBID = makeDouble(mainBid);
        AppClient appClient2 = new AppClient();
        ReqMsg reqMsg = EmaFactory.createReqMsg();
        consumer2 = EmaFactory.createOmmConsumer(EmaFactory.createOmmConsumerConfig().host("10.3.20.206:14002").host("10.3.20.206:14002").username("chigozirim.kawa"));
        long loginHandle2 = consumer2.registerClient(reqMsg.domainType(1), appClient2, consumer2);
        appClient2.postMessage2(mBID, RIC);
        System.out.println((new StringBuilder("Bid from Eikon : ")).append(eikonBid).append("Bid from website : ").append(mBID).toString());
        if(eikonBid != mBID)
        {
            System.out.println((new StringBuilder(String.valueOf(eikonBid))).append(" : is not same as : ").append(mBID).toString());
            appClient2.postMessage2(mBID, RIC);
        }
        consumer2.uninitialize();
    }

    public static void poster3(String mainBid, double eikonBid, String RIC, OmmConsumer consumer2, AppClient appClient2, ReqMsg reqMsg)
    {
        System.out.println("Posting from post1");
        double mBID = makeDouble(mainBid);
        consumer2 = EmaFactory.createOmmConsumer(EmaFactory.createOmmConsumerConfig().host("10.3.20.206:14002").host("10.3.20.206:14002").username("chigozirim.kawa"));
        appClient2.postMessage2(mBID, RIC);
        System.out.println((new StringBuilder("Bid from Eikon : ")).append(eikonBid).append("Bid from website : ").append(mBID).toString());
        if(eikonBid != mBID)
        {
            System.out.println((new StringBuilder(String.valueOf(eikonBid))).append(" : is not same as : ").append(mBID).toString());
            appClient2.postMessage2(mBID, RIC);
        }
    }

    public static void poster2(String mainBid, String mainASK, double eikonBid, String RIC)
    {
        System.out.println((new StringBuilder("String BID :----) ")).append(mainBid).append("String ASK --: ").append(mainASK).toString());
        double mBID = makeDouble(mainBid);
        double mASK = makeDouble(mainASK);
        AppClient appClient2 = new AppClient();
        ReqMsg reqMsg = EmaFactory.createReqMsg();
        OmmConsumer consumer2 = EmaFactory.createOmmConsumer(EmaFactory.createOmmConsumerConfig().host("10.3.20.206:14002").host("10.3.20.206:14002").username("chigozirim.kawa"));
        long loginHandle2 = consumer2.registerClient(reqMsg.domainType(1), appClient2, consumer2);
        System.out.println((new StringBuilder("Bid from Eikon : ")).append(eikonBid).append("Bid from website : ").append(mBID).toString());
        if(eikonBid != mBID)
        {
            System.out.println((new StringBuilder(String.valueOf(eikonBid))).append(" : is not same as : ").append(mBID).toString());
            appClient2.postMessage(mBID, mASK, RIC);
        }
        consumer2.unregister(loginHandle2);
        consumer2.uninitialize();
    }

    public static double subscribeBID(OmmConsumer consumer, String RIC)
    {
        MarketPrice theMarketPrice = (new MarketPrice.Builder()).withOmmConsumer(consumer).withName(RIC).withServiceName("EIKON").withSynchronousMode().build();
        theMarketPrice.open();
        String bid1 = theMarketPrice.getField(393).value().toString();
        double bid = Double.parseDouble(bid1);
        System.out.println((new StringBuilder("service name  ")).append(theMarketPrice.getField(791).value()).append(": : ").append(bid).toString());
        theMarketPrice.getServiceName();
        theMarketPrice.close();
        return bid;
    }

    private volatile boolean running;
    public static String RPound1 = "GBPSLLFIX=";
    public static String RCan1 = "CADSLLFIX=";
    public static String RUSD1 = "USDSLLFIX=";
    public static String RSwede1 = "SEKSLLFIX=";
    public static String RSwiss1 = "CHFSLLFIX=";
    public static String RYEN1 = "JPYSLLFIX=";
    public static String RNor1 = "NOKSLLFIX=";
    public static String REUR1 = "EURSLLFIX=";
    public static String RDAN1 = "DKKSLLFIX=";
    public static String RAUS1 = "AUDSLLFIX=";
    public static String RSaudi1 = "SARSLLFIX=";
    public static String RKuwait1 = "KWDSLLFIX=";
    public static String RUAE1 = "AEDSLLFIX=";
    public static String RRand1 = "ZARSLLFIX=";
    public static String RChina1 = "CNYSLLFIX=";
    public static String RHONG1 = "HKDSLLFIX=";
    public static String RSDR1 = "SDRSLLFIX=";
    public static String RCFA1 = "XAFSLLFIX=";
    public static String RGMB1 = "GMDSLLFIX=";
    public static String RGUI1 = "GNFSLLFIX=";
    public static String RCEDI1 = "GHSSLLFIX=";
    public static String RNGN1 = "NGNSLLFIX=";
    public static String RLIB1 = "LRDSLLFIX=";
    public static String RCABO1 = "CVESLLFIX=";
    public static String Rtest1 = "NGNT=ADOU";
    public static double VPound1;
    public static double VCan1;
    public static double VUSD1;
    public static double VSwede1;
    public static double VSwiss1;
    public static double VYEN1;
    public static double VNor1;
    public static double VEUR1;
    public static double VDAN1;
    public static double VAUS1;
    public static double VSaudi1;
    public static double VKuwait1;
    public static double VUAE1;
    public static double VRand1;
    public static double VChina1;
    public static double VHONG1;
    public static double VSDR1;
    public static double VCFA1;
    public static double VGMB1;
    public static double VGUI1;
    public static double VCEDI1;
    public static double VNGN1;
    public static double VLIB1;
    public static double VCABO1;
    public OmmConsumer consumer;
    public static OmmConsumer consumer2 = null;

}
