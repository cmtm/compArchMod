;Authors: Dirk Dubois, Chris Morin
;Date: March 28th, 2013
;File: dataHazzardTestBench1
;Data Hazzard Test Bench that shows a true RAW dependencie in the EX stage

	.data
	;Empty not playing with memory
	
	.code
	;Prepare registers
	DADDI R2, R2, 5
	NOP
	NOP
	DADDI R3, R3, 5
	NOP
	NOP
	DADDI R5, R5, 5	
	NOP
	NOP

	;Do Useful work
	;Without forwarding 2 RAW stalls expected due to R1 dependency
	;Adding forwarding from EX to back to EX will solve this stall
	
	DADD R1, R2, R3 ;Put something in R1
	DADD R4, R1, R5 ;Dependency on R1

	SYSCALL 0 ;Exit program