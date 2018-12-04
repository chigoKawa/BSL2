// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Consumer.java

package com.chigo.BSL;

import com.thomsonreuters.ema.access.*;
import java.io.PrintStream;
import java.util.Iterator;

class AppClient
    implements OmmConsumerClient
{

    AppClient()
    {
        _postID = 1;
        _postID2 = 100;
    }

    public void onRefreshMsg(RefreshMsg refreshMsg, OmmConsumerEvent event)
    {
        System.out.println((new StringBuilder("Item Name: ")).append(refreshMsg.hasName() ? refreshMsg.name() : "<not set>").toString());
        System.out.println((new StringBuilder("Service Name: ")).append(refreshMsg.hasServiceName() ? refreshMsg.serviceName() : "<not set>").toString());
        System.out.println((new StringBuilder("Item State: ")).append(refreshMsg.state()).toString());
        if(refreshMsg.domainType() == 1 && refreshMsg.state().streamState() == 1 && refreshMsg.state().dataState() == 1)
        {
            _postStreamID = refreshMsg.streamId();
            _ommConsumer = (OmmConsumer)event.closure();
            _streamHandle = event.handle();
            System.out.println("System refresh, starting posting...");
        }
        if(132 == refreshMsg.payload().dataType())
            _postStreamID = refreshMsg.streamId();
        _ommConsumer = (OmmConsumer)event.closure();
        _streamHandle = event.handle();
        System.out.println();
    }

    public void onUpdateMsg(UpdateMsg updateMsg, OmmConsumerEvent event)
    {
        System.out.println((new StringBuilder("Item Name: ")).append(updateMsg.hasName() ? updateMsg.name() : "<not set>").toString());
        System.out.println((new StringBuilder("Service Name: ")).append(updateMsg.hasServiceName() ? updateMsg.serviceName() : "<not set>").toString());
        if(132 == updateMsg.payload().dataType())
            decode2(updateMsg.payload().fieldList());
        System.out.println();
    }

    public void onStatusMsg(StatusMsg statusMsg, OmmConsumerEvent event)
    {
        System.out.println((new StringBuilder("Item Name: ")).append(statusMsg.hasName() ? statusMsg.name() : "<not set>").toString());
        System.out.println((new StringBuilder("Service Name: ")).append(statusMsg.hasServiceName() ? statusMsg.serviceName() : "<not set>").toString());
        if(statusMsg.hasState())
            System.out.println((new StringBuilder("Item State: ")).append(statusMsg.state()).toString());
        System.out.println();
    }

    public void postMessage(double BID, double ASK, String RIC)
    {
        System.out.println("calling post msg... > ");
        try
        {
            Thread.sleep(300L);
        }
        catch(Exception exception) { }
        FieldList nestedFieldList = EmaFactory.createFieldList();
        if(BID != 0.0D)
        {
            nestedFieldList.add(EmaFactory.createFieldEntry().realFromDouble(393, BID, 12));
            nestedFieldList.add(EmaFactory.createFieldEntry().realFromDouble(275, ASK, 12));
            nestedFieldList.add(EmaFactory.createFieldEntry().realFromDouble(22, BID, 12));
            nestedFieldList.add(EmaFactory.createFieldEntry().realFromDouble(25, ASK, 12));
            nestedFieldList.add(EmaFactory.createFieldEntry().ascii(831, "BSL Webbie"));
        }
        UpdateMsg nestedUpdateMsg = EmaFactory.createUpdateMsg().streamId(1).name(RIC).payload(nestedFieldList);
        PostMsg postMsg = EmaFactory.createPostMsg().postId(_postID2++).serviceName("MLIP").name(RIC).solicitAck(true).payload(nestedUpdateMsg).complete(true);
        _ommConsumer.submit(postMsg, _streamHandle);
    }

    public void postMessage2(double BID, String RIC)
    {
        System.out.println("calling post msg... > ");
        try
        {
            Thread.sleep(300L);
        }
        catch(Exception exception) { }
        FieldList nestedFieldList = EmaFactory.createFieldList();
        if(BID != 0.0D)
        {
            nestedFieldList.add(EmaFactory.createFieldEntry().realFromDouble(393, BID, 12));
            nestedFieldList.add(EmaFactory.createFieldEntry().realFromDouble(22, BID, 12));
            nestedFieldList.add(EmaFactory.createFieldEntry().ascii(831, "BSL Webbie_"));
        }
        UpdateMsg nestedUpdateMsg = EmaFactory.createUpdateMsg().streamId(1).name(RIC).payload(nestedFieldList);
        PostMsg postMsg = EmaFactory.createPostMsg().postId(_postID++).serviceName("MLIP").name(RIC).solicitAck(true).payload(nestedUpdateMsg).complete(true);
        _ommConsumer.submit(postMsg, _streamHandle);
    }

    void decode(AckMsg ackMsg)
    {
        if(ackMsg.hasMsgKey())
            System.out.println((new StringBuilder("Item Name: ")).append(ackMsg.hasName() ? ackMsg.name() : "not set").append("\nService Name: ").append(ackMsg.hasServiceName() ? ackMsg.serviceName() : "not set").toString());
        System.out.println((new StringBuilder("Ack Id: ")).append(ackMsg.ackId()).toString());
        if(ackMsg.hasNackCode())
            System.out.println((new StringBuilder("Nack Code: ")).append(ackMsg.nackCodeAsString()).toString());
        if(ackMsg.hasText())
            System.out.println((new StringBuilder("Text: ")).append(ackMsg.text()).toString());
        switch(ackMsg.attrib().dataType())
        {
        case 133: 
            decode(ackMsg.attrib().elementList());
            break;

        case 132: 
            decode(ackMsg.attrib().fieldList());
            break;
        }
        switch(ackMsg.payload().dataType())
        {
        case 133: 
            decode(ackMsg.payload().elementList());
            break;

        case 132: 
            decode(ackMsg.payload().fieldList());
            break;
        }
    }

    void decode(Msg msg)
    {
        switch(msg.attrib().dataType())
        {
        case 133: 
            decode(msg.attrib().elementList());
            break;

        case 132: 
            decode(msg.attrib().fieldList());
            break;
        }
        switch(msg.payload().dataType())
        {
        case 133: 
            decode(msg.payload().elementList());
            break;

        case 132: 
            decode(msg.payload().fieldList());
            break;
        }
    }

    void decode(ElementList elementList)
    {
        for(Iterator iterator = elementList.iterator(); iterator.hasNext();)
        {
            ElementEntry elementEntry = (ElementEntry)iterator.next();
            System.out.print((new StringBuilder(" Name = ")).append(elementEntry.name()).append(" DataType: ").append(DataType.asString(elementEntry.load().dataType())).append(" Value: ").toString());
            if(1 == elementEntry.code())
                System.out.println(" blank");
            else
                switch(elementEntry.loadType())
                {
                case 8: // '\b'
                    System.out.println(elementEntry.real().asDouble());
                    break;

                case 9: // '\t'
                    System.out.println((new StringBuilder(String.valueOf(elementEntry.date().day()))).append(" / ").append(elementEntry.date().month()).append(" / ").append(elementEntry.date().year()).toString());
                    break;

                case 10: // '\n'
                    System.out.println((new StringBuilder(String.valueOf(elementEntry.time().hour()))).append(":").append(elementEntry.time().minute()).append(":").append(elementEntry.time().second()).append(":").append(elementEntry.time().millisecond()).toString());
                    break;

                case 3: // '\003'
                    System.out.println(elementEntry.intValue());
                    break;

                case 4: // '\004'
                    System.out.println(elementEntry.uintValue());
                    break;

                case 17: // '\021'
                    System.out.println(elementEntry.ascii());
                    break;

                case 14: // '\016'
                    System.out.println(elementEntry.enumValue());
                    break;

                case 19: // '\023'
                    System.out.println(elementEntry.rmtes());
                    break;

                case 270: 
                    System.out.println((new StringBuilder(String.valueOf(elementEntry.error().errorCode()))).append(" (").append(elementEntry.error().errorCodeAsString()).append(")").toString());
                    break;

                default:
                    System.out.println();
                    break;
                }
        }

    }

    public void onGenericMsg(GenericMsg genericmsg, OmmConsumerEvent ommconsumerevent)
    {
    }

    public void onAckMsg(AckMsg ackMsg, OmmConsumerEvent event)
    {
        System.out.println("----- Ack message ----");
        decode(ackMsg);
        System.out.println("Continue posting...");
    }

    public void onAllMsg(Msg msg1, OmmConsumerEvent ommconsumerevent)
    {
    }

    void decode2(FieldList fieldList)
    {
        for(Iterator iterator = fieldList.iterator(); iterator.hasNext();)
        {
            FieldEntry fieldEntry = (FieldEntry)iterator.next();
            System.out.print((new StringBuilder("Fid: ")).append(fieldEntry.fieldId()).append(" Name2 = ").append(fieldEntry.name()).append(" DataType: ").append(DataType.asString(fieldEntry.load().dataType())).append(" Value: ").toString());
            if(1 == fieldEntry.code())
                System.out.println(" blank");
            else
                switch(fieldEntry.loadType())
                {
                case 8: // '\b'
                    System.out.println(fieldEntry.real().asDouble());
                    break;

                case 9: // '\t'
                    System.out.println((new StringBuilder(String.valueOf(fieldEntry.date().day()))).append(" / ").append(fieldEntry.date().month()).append(" / ").append(fieldEntry.date().year()).toString());
                    break;

                case 10: // '\n'
                    System.out.println((new StringBuilder(String.valueOf(fieldEntry.time().hour()))).append(":").append(fieldEntry.time().minute()).append(":").append(fieldEntry.time().second()).append(":").append(fieldEntry.time().millisecond()).toString());
                    break;

                case 3: // '\003'
                    System.out.println(fieldEntry.intValue());
                    break;

                case 4: // '\004'
                    System.out.println(fieldEntry.uintValue());
                    break;

                case 17: // '\021'
                    System.out.println(fieldEntry.ascii());
                    break;

                case 14: // '\016'
                    System.out.println(fieldEntry.hasEnumDisplay() ? ((Object) (fieldEntry.enumDisplay())) : ((Object) (Integer.valueOf(fieldEntry.enumValue()))));
                    break;

                case 19: // '\023'
                    System.out.println(fieldEntry.rmtes());
                    break;

                case 270: 
                    System.out.println((new StringBuilder("(")).append(fieldEntry.error().errorCodeAsString()).append(")").toString());
                    break;

                default:
                    System.out.println();
                    break;
                }
        }

    }

    void decode(FieldList fieldList)
    {
        for(Iterator iterator = fieldList.iterator(); iterator.hasNext();)
        {
            FieldEntry fieldEntry = (FieldEntry)iterator.next();
            System.out.print((new StringBuilder("Fid: ")).append(fieldEntry.fieldId()).append(" Name = ").append(fieldEntry.name()).append(" DataType: ").append(DataType.asString(fieldEntry.load().dataType())).append(" Value: ").toString());
            if(1 == fieldEntry.code())
                System.out.println(" blank");
            else
                switch(fieldEntry.loadType())
                {
                case 8: // '\b'
                    System.out.println(fieldEntry.real().asDouble());
                    break;

                case 9: // '\t'
                    System.out.println((new StringBuilder(String.valueOf(fieldEntry.date().day()))).append(" / ").append(fieldEntry.date().month()).append(" / ").append(fieldEntry.date().year()).toString());
                    break;

                case 10: // '\n'
                    System.out.println((new StringBuilder(String.valueOf(fieldEntry.time().hour()))).append(":").append(fieldEntry.time().minute()).append(":").append(fieldEntry.time().second()).append(":").append(fieldEntry.time().millisecond()).toString());
                    break;

                case 3: // '\003'
                    System.out.println(fieldEntry.intValue());
                    break;

                case 4: // '\004'
                    System.out.println(fieldEntry.uintValue());
                    break;

                case 17: // '\021'
                    System.out.println(fieldEntry.ascii());
                    break;

                case 14: // '\016'
                    System.out.println(fieldEntry.hasEnumDisplay() ? ((Object) (fieldEntry.enumDisplay())) : ((Object) (Integer.valueOf(fieldEntry.enumValue()))));
                    break;

                case 19: // '\023'
                    System.out.println(fieldEntry.rmtes());
                    break;

                case 270: 
                    System.out.println((new StringBuilder("(")).append(fieldEntry.error().errorCodeAsString()).append(")").toString());
                    break;

                default:
                    System.out.println();
                    break;
                }
        }

    }

    private OmmConsumer _ommConsumer;
    private long _streamHandle;
    private int _postStreamID;
    int _postID;
    int _postID2;
}
