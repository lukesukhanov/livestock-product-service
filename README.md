<a name="readme-top"></a>

## About the application
The product service for the 'Livestock' project.<br />
<p>

## How to run the project
Start Spring Boot application using 'dev' profile (-Dspring.profiles.active=dev).<br />
Now you can find Swagger docs on localhost:8082/swagger-ui/index.html.

## What does it look like
![alt text](https://github.com/lukesukhanov/livestock-product-service/blob/main/screenshot.jpg)

## What features are presented
<ul>
  <li>You can get products using paging and filtering.</li>
  <li>You can search products (by name and description).</li>
  <li>You can filter products by min and max price.</li>
  <li>You can register an account on authorization server.</li>
  <li>You can login to your registered account.</li>
  <li>You can add products to the cart (works only for authenticated users, sadly).</li>
  <li>You can open the cart.</li>
  <li>You can remove one product from the cart.</li>
  <li>You can remove all products from the cart.</li>
</ul>

## What tools are exploited
<ul>
  <li>Spring Boot</li>
  <li>Spring Cloud</li>
  <li>Docker</li>
</ul>
