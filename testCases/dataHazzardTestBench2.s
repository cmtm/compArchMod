;Authors: Dirk Dubois, Chris Morin
;Date: March 28th, 2013
;File: dataHazzardTestBench2
;Data Hazzard Test Bench that shows a true RAW dependencie in the mem stage

	.data
	
	.code
	;Prepare registers
	DADDI R1, R0, 0 ;Put a location in R1
	NOP ;Remove stalls for RAW when setting up the store
	NOP
	SD R0, 0(R1) ;Store a value of 0 at R1 location
	
	DADDI R2, R2, 3 
	DADDI R3, R3, 3
	;Let the init instructions complete so the pipe is empty
	NOP
	NOP
	NOP
	NOP
	;Do Useful work
	;Without forwarding 4 RAW stalls expected due to R1 dependency
	;2 RAW for the LD and 2 RAW for the SD
	;Adding forwarding from EX to back to EX will solve this stall
	
	DSUB R1, R2, R3 ;Put something in R1
	LD R4, 0(R1) ;Dependence on R1 needs forwarding from EX to MEM
	SD R4, 0(R1) ;Dependence on R1 needs forwarding from MEM to EX
	
	SYSCALL 0 ;Exit program