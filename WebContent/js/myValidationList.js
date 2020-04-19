
			$( "#dialog" ).dialog({
			     autoOpen: false,
			    resizable:false,
			  	draggable: false,
			  	position:{my:"center",
			    at: "center",
			    of: "body"},
			    open: function( event, ui ) {
			    $("#stopActive").show();
			  },
			  close: function( event, ui ) {
			    $("#stopActive").hide();
			  },
		 })

		   $(".fa-trash").click(function() {
			var arrayString = $(this).attr('id').split("-") ;
			/* let arrayString = $(this).val().split("-"); */
            $("#dialog").dialog({
             buttons : {
             "Yes" : function() {
            	 window.location.href = "deleteMotorCycle.do?id="+ arrayString[0]
                 + "&pageNum="+ arrayString[1];                 
		        
		          $(this).dialog("close");
             },
              "No" : function() {
              $(this).dialog("close");
                  }
               }
              });

           $("#dialog").dialog("open");
           var xns = $("#dialogDelete").text("[CTC000110C]: " + arrayString[0] + " を削除します。よろしいですか？");	
		});
		/* var x = $("#timeout").text();
		if(x != ""){
			setTimeout(function(){$("#timeout").text('');}, 5000)
		}*/
		window.history.pushState(null, "Title","listMotorCycle.do");	