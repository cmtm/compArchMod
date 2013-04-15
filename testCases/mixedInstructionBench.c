/**
*@file mixedInstructionBench.c
*@author Dirk Dubois, Chris Morin
*@brief A mixed instruction set bench mark to test forwarding in
the MIPS64 EDU processor
*/

void main (void){

	int i, j; //Counting loops
	int values[100];
	int result[100];

	j = 0;
	for(i = 0; i<100; i++){
		values[i] = j; //Populate values table
		result [i] = 0;
		j++;
	}
	for(i = 0; i<100; i++){
		result[i] = result [i] + values[i]; //Add one array to the other
	}
	
	return;

}