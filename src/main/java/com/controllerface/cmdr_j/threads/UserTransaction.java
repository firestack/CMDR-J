package com.controllerface.cmdr_j.threads;

import com.controllerface.cmdr_j.classes.tasks.TaskCost;
import com.controllerface.cmdr_j.classes.tasks.TaskRecipe;
import com.controllerface.cmdr_j.classes.tasks.TaskType;
import javafx.scene.paint.Color;
import javafx.util.Pair;

import java.util.Map;

/**
 * Created by Controllerface on 5/5/2018.
 */
public class UserTransaction
{
    public enum TransactionType
    {
        STATUS,
        ARRIVAL,
        MARKET,
        INVENTORY,
        BLUEPRINT,
        MESSAGE,
        VEHICLE,
    }

    public enum MessageType
    {
        GENERAL(Color.web("#eeeeee")),
        INVENTORY(Color.web("#24AB60")),
        LOADOUT(Color.web("#ffb000")),
        ENGINEERING(Color.web("#ff7100")),
        COMBAT(Color.web("#e91a1a")),
        TRAVEL(Color.web("#1155ff")),
        EXPLORATION(Color.web("#7345ff")),

        ;

        final Color color;

        MessageType(Color color)
        {
            this.color = color;
        }

        public Color getColor()
        {
            return color;
        }
    }

    private final TransactionType transactionType;

    private final boolean inSRV;
    private final long transactionAmount;
    private final String message;
    private final MessageType messageType;
    private final TaskCost inventoryItem;
    private final Map<String, Object> statusObject;
    private final Pair<TaskType, TaskRecipe> blueprint;


    private UserTransaction(Builder builder)
    {
        this.inSRV = builder.inSRV;
        this.transactionType = builder.transactionType;
        this.transactionAmount = builder.transactionAmount;
        this.message = builder.message;
        this.messageType = builder.messageType;
        this.inventoryItem = builder.inventoryItem;
        this.statusObject = builder.statusObject;
        this.blueprint = builder.blueprint;
    }

    public static Builder type(TransactionType transactionType)
    {
        return new Builder(transactionType);
    }

    public TransactionType getTransactionType()
    {
        return transactionType;
    }

    public boolean isInSRV()
    {
        return inSRV;
    }

    public long getTransactionAmount()
    {
        return transactionAmount;
    }

    public String getMessage()
    {
        return message;
    }

    public MessageType getMessageType()
    {
        return messageType;
    }

    public Map<String, Object> getStatusObject()
    {
        return statusObject;
    }

    public TaskCost getInventoryItem()
    {
        return inventoryItem;
    }

    public Pair<TaskType, TaskRecipe> getBlueprint()
    {
        return blueprint;
    }




    public static class Builder
    {
        private final TransactionType transactionType;
        private boolean inSRV;
        private long transactionAmount;
        private String message;
        private MessageType messageType;
        private TaskCost inventoryItem;
        private Map<String, Object> statusObject;
        private Pair<TaskType, TaskRecipe> blueprint;


        public Builder(TransactionType transactionType)
        {
            this.transactionType = transactionType;
        }

        public Builder setInSRV(boolean inSRV)
        {
            this.inSRV = inSRV;
            return this;
        }

        public Builder setTransactionAmount(long transactionAmount)
        {
            this.transactionAmount = transactionAmount;
            return this;
        }

        public Builder setMessage(String message)
        {
            this.message = message;
            return this;
        }

        public Builder setMessageType(MessageType messageType)
        {
            this.messageType = messageType;
            return this;
        }

        public Builder setInventoryItem(TaskCost inventoryItem)
        {
            this.inventoryItem = inventoryItem;
            return this;
        }

        public Builder setStatusObject(Map<String, Object> statusObject)
        {
            this.statusObject = statusObject;
            return this;
        }

        public Builder setBlueprint(Pair<TaskType, TaskRecipe> blueprint)
        {
            this.blueprint = blueprint;
            return this;
        }

        public UserTransaction build()
        {
            return new UserTransaction(this);
        }
    }
}
