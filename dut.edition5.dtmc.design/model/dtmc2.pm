dtmc	
module distance1
	
	s : [0..8] init 0;
	
	
	[]	s=0 -> (0.33):(s'=2)+(0.67):(s'=1);	
	[]	s=1 -> 1.0:(s'=8);	
	
	[]	s=2 -> 1.0:(s'=3);	
	
	[]	s=3 -> 1.0:(s'=4);	
	
	
	[]	s=4 -> (0.75):(s'=5)+(0.25):(s'=7);	
	[]	s=5 -> 1.0:(s'=6);	
	
	[]	s=6 -> 1.0:(s'=4);	
	
	[]	s=7 -> 1.0:(s'=8);	
	
	
	
endmodule


rewards"cost"
	s=1 : 7.0;	
endrewards

rewards"time"
	s=5 : 2.5;	
endrewards

