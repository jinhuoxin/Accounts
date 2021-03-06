/*
 * Copyright (C) 2011 Markus Junginger, greenrobot (http://greenrobot.de)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package de.greenrobot.daogenerator.gentest;

import de.greenrobot.daogenerator.DaoGenerator;
import de.greenrobot.daogenerator.Entity;
import de.greenrobot.daogenerator.Property;
import de.greenrobot.daogenerator.Schema;
import de.greenrobot.daogenerator.ToMany;

/**
 * Generates entities and DAOs for the example project DaoExample.
 * 
 * Run it as a Java application (not Android).
 * 
 * @author Markus
 */
public class ExampleDaoGenerator {

    public static void main(String[] args) throws Exception {
        Schema schema = new Schema(1000, "yjy.com.accounts.databases");
        addNote(schema);
        new DaoGenerator("/Users/yujinyang/tools/mygithub/Accounts/DaoGenerator/src-template").
                generateAll(schema, "/Users/yujinyang/tools/mygithub/Accounts/app/src/main/java/");
    }

    /**
     * int      ID      主键ID
     * double   coast   花费金额
     * String      paymethod     支付方式
     * String      usage     用途
     * String   remark  备注
     * date     date    时间
     *
     * @param schema
     */
    private static void addNote(Schema schema) {
        Entity note = schema.addEntity("AccountInfo");
        note.addIdProperty().primaryKey().autoincrement();
        note.addDoubleProperty("cost").notNull();
        note.addStringProperty("paymethod").notNull();
        note.addStringProperty("usage").notNull();
        note.addStringProperty("remark").notNull();
        note.addDateProperty("date").notNull();
    }

    private static void addCustomerOrder(Schema schema) {
        Entity customer = schema.addEntity("Customer");
        customer.addIdProperty();
        customer.addStringProperty("name").notNull();

        Entity order = schema.addEntity("Order");
        order.setTableName("ORDERS"); // "ORDER" is a reserved keyword
        order.addIdProperty();
        Property orderDate = order.addDateProperty("date").getProperty();
        Property customerId = order.addLongProperty("customerId").notNull().getProperty();
        order.addToOne(customer, customerId);

        ToMany customerToOrders = customer.addToMany(order, customerId);
        customerToOrders.setName("orders");
        customerToOrders.orderAsc(orderDate);
    }

}
