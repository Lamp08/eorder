this project contains 4 data:
user - contains data of users.
cart - contains mapping of cart and user. A user can have several carts.
cartDetails - contains mapping of cart,items and their quantities.
item - contains data about the item and their total quantites present.


Item Api's

1. /ecommerce/item/getAllItems -                    this will give all the items and their details.
2. /ecommerce/item/insertItem  -                    this will insert any new item as passed in json
3. /ecommerce/item/deleteItem/{itemId}/{quantity} - this will delete the quantity mentioned for a certain product.
4. /ecommerce/item/updateItem   -                   this will update the item as passed in the json


User Api's
1. /ecommerce/user/add - this will add the user mention in the json.


Order Api's

1. /ecommerce/order/add - this will add new orders as passed in the list of orderDto. this will take care if the quantity is within the limits or not
                           if not then respective order wont be added.

2. /ecommerce/order/allOrders - this will all the order and their users and date when its created on.
