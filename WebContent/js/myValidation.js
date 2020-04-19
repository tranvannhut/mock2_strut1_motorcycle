$().ready(function() {
	$("button[name='submit']").click(function(){
	$("#checkForm").validate({
		
		onfocusout: false, 
		 onkeyup: false, 
		 onclick: false,
		 
		rules : {
			"id" : {
				checkSpace : true,	
				myDigits : true,
			},
			"makerOfId" : {
				required : true,
			},
			"makerId" : {
				required : true,
			},
			"motorCycleName" : {
				required : true,
			    validateText : true,
			},
			"motorCycleOfName" : {
				required : true,
				validateText : true,
			},
			"cylinderCapacity" : {
				myDigits : true,
			},
			"releasedInYear" : {
				yearFormat : true,
			}
		},
		messages : {
			"id" : {
				required : "[CTC000570E]:を入力してください。",
				checkSpace : "[CTC000570E]:を入力してください。",
				myDigits : " [CTC000470E]：にはより大きい整数値を入力してください。",
			},
			"makerOfId" : {
				required : "[CTC000350E]:にはアルファベットと数字のみを入力してください。",
			},
			"motorCycleOfName" : {
				required : "[CTC000570E]:を入力してください。",
				validateText : "[CTC000350E]:にはアルファベットと数字のみを入力してください。",
			},
			"makerId" : {
				required : "[CTC000350E]:にはアルファベットと数字のみを入力してください。",			
			},
			"motorCycleName" : {
				required : "[CTC000570E]:を入力してください。",
				validateText : "[CTC000350E]:にはアルファベットと数字のみを入力してください。",
			},
			"cylinderCapacity" : {
				myDigits : "[CTC000470E]：にはより大きい整数値を入力してください。",
			},
			"releasedInYear" : {
				yearFormat : "[CTC000450E]:には日付を表す文字列を(yyyyの形式で)入力してください。",
			},
			
		},
	      /*   highlight : function(element, errorClass, validClass) {
			$(element).parent('.checkForm').addClass('error');
			$(element).addClass(errorClass).removeClass(validClass);
		},
		unhighlight : function(element, errorClass, validClass) {
			$(element).parent('.checkForm').removeClass('error');
			$(element).addClass(validClass).removeClass(errorClass);
		}*/
	});
	});
	$.validator.addMethod("yearFormat",function(value, element) {
                let format = /^\d{4}$/
				return this.optional(element)
						|| (format.test(value));
			});
	$.validator.addMethod("checkSpace",function(value, element) {
        let valueTrim = value.trim().length;
        if(valueTrim == 0){
        	element.value  = "";
        }
             
		return  valueTrim != 0;
	});
	$.validator.addMethod("myDigits",function(value, element) {
		let trimValue = value.trim();
        let format = /^[0-9]+$/
		return this.optional(element)
				|| (format.test(trimValue));
	});
	$.validator.addMethod("validateText",function(value, element) {
        let format = /^[a-zA-Z0-9_ ]*$/
		return this.optional(element)
				|| (format.test(value));
	});
	
	 $("#id").keyup(function(){
		 $("#idSame").text("");
	 })
	 
});