/*
 * LH.java
 *
 * 20th may 2006
 * Instruction LH of the MIPS64 Instruction Set
 * (c) 2006 EduMips64 project - Trubia Massimo, Russo Daniele
 *
 * This file is part of the EduMIPS64 project, and is released under the GNU
 * General Public License.
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 */

package edumips64.core.is;
import edumips64.core.*;
import edumips64.utils.*;


/** <pre>
 *  Syntax:        LH rt, offset(base)
 *  Description:   rt = memory[base+offset]
 *  Purpose:       To load a halfword from memory as a signed value
 * </pre>
 * @author Trubia Massimo, Russo Daniele
 */
class LH extends Loading
{
    final String OPCODE_VALUE="100001";
    public LH()
    {
        super.OPCODE_VALUE = OPCODE_VALUE;
        this.name="LH";
        this.memoryOpSize = 2;
    }

    public  void MEM() throws IrregularStringOfBitsException, NotAlignException, MemoryElementNotFoundException, AddressErrorException, IrregularWriteOperationException
    { 
        MemoryElement memEl = memory.getCellByAddress(address); 

        //reading from the memory element and saving values on LMD register
        TR[LMD_REGISTER].writeHalf(memEl.readHalf((int)(address%8)));
        if(enableForwarding)
        {
            doWB();
        }
    }        
}
