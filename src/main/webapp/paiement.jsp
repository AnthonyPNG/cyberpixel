<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Paiement</title>
	<style>		
		* {
		  box-sizing: border-box;
		}
		
		.row {
		  display: -ms-flexbox; /* IE10 */
		  display: flex;
		  -ms-flex-wrap: wrap; /* IE10 */
		  flex-wrap: wrap;
		  margin: 0 -16px;
		}
		
		.col-25 {
		  -ms-flex: 25%; /* IE10 */
		  flex: 25%;
		}
		
		.col-50 {
		  -ms-flex: 50%; /* IE10 */
		  flex: 50%;
		}
		
		.col-75 {
		  -ms-flex: 75%; /* IE10 */
		  flex: 75%;
		}
		
		.col-25,
		.col-50,
		.col-75 {
		  padding: 0 16px;
		}
		
		.container {
		  background-color: #f2f2f2;
		  padding: 5px 20px 15px 20px;
		  border: 1px solid lightgrey;
		  border-radius: 3px;
		}
		
		input[type=text] {
		  width: 100%;
		  margin-bottom: 20px;
		  padding: 12px;
		  border: 1px solid #ccc;
		  border-radius: 3px;
		}
		
		label {
		  margin-bottom: 10px;
		  display: block;
		}
		
		.icon-container {
		  margin-bottom: 20px;
		  padding: 7px 0;
		  font-size: 24px;
		}
		
		.btn {
		  background-color: #04AA6D;
		  color: white;
		  padding: 12px;
		  margin: 10px 0;
		  border: none;
		  width: 100%;
		  border-radius: 3px;
		  cursor: pointer;
		  font-size: 17px;
		}
		
		.btn:hover {
		  background-color: #45a049;
		}
		
		a {
		  color: #2196F3;
		}
		
		hr {
		  border: 1px solid lightgrey;
		}
		
		span.price {
		  float: right;
		  color: grey;
		}
		
		/* Responsive layout - when the screen is less than 800px wide, make the two columns stack on top of each other instead of next to each other (also change the direction - make the "cart" column go on top) */
		@media (max-width: 800px) {
		  .row {
		    flex-direction: column-reverse;
		  }
		  .col-25 {
		    margin-bottom: 20px;
		  }
		}
	</style>
	<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
</head>

<body>
	<div class="header">
		<div class="text-box">
				
			<div class="row">
			  <div class="col-75">
			    <div class="container">
			      <form action="">			
			          <div class="col-50">
			            <h1>Paiement en ligne</h1>
			            <div class="icon-container">
			              <i class="fa fa-cc-visa" style="color:navy;"></i>
			              <i class="fa fa-cc-amex" style="color:blue;"></i>
			              <i class="fa fa-cc-mastercard" style="color:red;"></i>
			              <i class="fa fa-cc-discover" style="color:orange;"></i>
			            </div>
			            <label for="nom">Nom sur la carte</label>
			            <input type="text" name="nom">
			            <label for="num">N° de carte</label>
			            <input type="text" name="num">
			            <label for="expmonth">Exp Month</label>
			            <input type="number" name="mois">
			            <div class="row">
			              <div class="col-50">
			                <label for="expyear">Exp Year</label>
			                <input type="number" name="year">
			              </div>
			              <div class="col-50">
			                <label for="cvv">Cryptogramme visuel</label>
			                <input type="number" name="cvv">
			              </div>
			            </div>
			          </div>			          
			        </div>
			        
			        <input type="submit" value="Valider" class="btn">
			        
			      </form>
			      <button onclick="alertAbandon();">Abandonner</button>
			    </div>
			  </div>
			  
			  <div class="col-25">
			    <div class="container">
			      <h4>Cart <span class="price" style="color:black"><i class="fa fa-shopping-cart"></i> <b>4</b></span></h4>
			      <p>Product 1 <span class="price">$15</span></p>
			      <p>Product 2 <span class="price">$5</span></p>
			      <p>Product 3 <span class="price">$8</span></p>
			      <p>Product 4 <span class="price">$2</span></p>
			      <hr>
			      <p>Total <span class="price" style="color:black"><b>$30</b></span></p>
			    </div>
			  </div>
			</div>
		</div>
	</div>
</body>

<script type="text/javascript">
function alertAbandon() {
	swal({
		  title: "Are you sure?",
		  text: "Once deleted, you will not be able to recover this imaginary file!",
		  icon: "warning",
		  buttons: true,
		  dangerMode: true,
		})
		.then((willDelete) => {
		  if (willDelete) {
		    swal("Poof! Your imaginary file has been deleted!", {
		      icon: "success",
		    });
		  } else {
		    swal("Your imaginary file is safe!");
		  }
		});
}
</script>
</html>