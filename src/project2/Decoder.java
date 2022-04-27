package project2;

import java.util.ArrayList;
import java.util.HashMap;

public class Decoder {

/**
 * BranchCounter is used to give each label a unique name, once you auto
 * generate the label "label1", the next generated label will be "lable2"
 * 
 * Instruction line keeps track of the current instruction line. Right
 * now the only application of this is to make sure that if a branch is
 * trying to jump to a label that already exists, it has the proper label 
 * name instead of generating a new one.
 */
private int labelCounter, instructionLine;

/**
 * The branchList the address of the jump and the associated label name
 */
private HashMap<Integer, String> labelList;
private ArrayList<Instruction> lookup;
	
	public Decoder()
	{
		lookup = new ArrayList<>();
		labelList = new HashMap<Integer, String>();
		labelCounter = 1;
		instructionLine = 0;
		
		Instruction add = new Instruction("10001011000", "ADD", Type.R);
		lookup.add(add);
		
		Instruction addi = new Instruction("1001000100", "ADDI", Type.I);
		lookup.add(addi);
		
		Instruction addis = new Instruction("1011000100", "ADDIS", Type.I);
		lookup.add(addis);
		
		Instruction adds = new Instruction("10101011000", "ADDS", Type.R);
		lookup.add(adds);
		
		Instruction and = new Instruction("10001010000", "AND", Type.R);
		lookup.add(and);
		
		Instruction andi = new Instruction("1001001000", "ANDI", Type.I);
		lookup.add(andi);
		
		Instruction andis = new Instruction("1111001000", "ANDIS", Type.I);
		lookup.add(andis);
		
		Instruction ands = new Instruction("1110101000", "ANDS", Type.R);
		lookup.add(ands);
		
		Instruction b = new Instruction("000101", "B", Type.R);
		lookup.add(b);
		
		Instruction bl = new Instruction("100101", "BL", Type.B);
		lookup.add(bl);
		
		Instruction br = new Instruction("11010110000", "BR", Type.R);
		lookup.add(br);
		
		Instruction cbnz = new Instruction("10110101", "CBNZ", Type.CB);
		lookup.add(cbnz);
		
		Instruction cbz = new Instruction("10110100", "CBZ", Type.CB);
		lookup.add(cbz);
		
		Instruction b_cond = new Instruction("01010100", "B.", Type.CB);
		lookup.add(b_cond);
		
		Instruction dump = new Instruction("11111111110", "DUMP", Type.R);
		lookup.add(dump);
		
		Instruction eor = new Instruction("11001010000", "EOR", Type.R);
		lookup.add(eor);
		
		Instruction eori = new Instruction("1101001000", "EORI", Type.I);
		lookup.add(eori);
		
		Instruction faddd = new Instruction("00011110011", "FADDD", Type.R);
		lookup.add(faddd);
		
		Instruction fadds = new Instruction("00011110001", "FADDD", Type.R);
		lookup.add(fadds);
		
		Instruction fcmpd = new Instruction("00011110011", "FCMPD", Type.R);
		lookup.add(fcmpd);
		
		Instruction fcmps = new Instruction("00011110001", "FCMPS", Type.R);
		lookup.add(fcmps);
		
		Instruction fdivd = new Instruction("00011110011", "FDIVD", Type.R);
		lookup.add(fdivd);
		
		Instruction fdivs = new Instruction("00011110001", "FDIVS", Type.R);
		lookup.add(fdivs);
		
		Instruction fmuld = new Instruction("00011110011", "FMULD", Type.R);
		lookup.add(fmuld);
		
		Instruction fmuls = new Instruction("00011110001", "FMULS", Type.R);
		lookup.add(fmuls);
		
		Instruction fsubd = new Instruction("00011110011", "FSUBD", Type.R);
		lookup.add(fsubd);
		
		Instruction fsubs = new Instruction("00011110001", "FSUBS", Type.R);
		lookup.add(fsubs);
		
		Instruction halt = new Instruction("11111111111", "HALT", Type.R);
		lookup.add(halt);
		
		Instruction ldur = new Instruction("11111000010", "LDUR", Type.D);
		lookup.add(ldur);
		
		Instruction ldurb = new Instruction("00111000010", "LDURB", Type.D);
		lookup.add(ldurb);
		
		Instruction ldurd = new Instruction("11111100010", "LDURD", Type.D);
		lookup.add(ldurd);
		
		Instruction ldurh = new Instruction("01111000010", "LDURH", Type.D);
		lookup.add(ldurh);
		
		Instruction ldurs = new Instruction("10111100010", "LDURS", Type.D);
		lookup.add(ldurs);
		
		Instruction ldursw = new Instruction("10111000100", "LDURSW", Type.D);
		lookup.add(ldursw);
		
		Instruction lsl = new Instruction("11010011011", "LSL", Type.R);
		lookup.add(lsl);
		
		Instruction lsr = new Instruction("11010011010", "LSR", Type.R);
		lookup.add(lsr);
		
		Instruction mul = new Instruction("10011011000", "MUL", Type.R);
		lookup.add(mul);
		
		Instruction orr = new Instruction("10101010000", "ORR", Type.R);
		lookup.add(orr);
		
		Instruction orri = new Instruction("1011001000", "ORRI", Type.I);
		lookup.add(orri);
		
		Instruction prnl = new Instruction("11111111100", "PRNL", Type.R);
		lookup.add(prnl);
		
		Instruction prnt = new Instruction("11111111101", "PRNT", Type.R);
		lookup.add(prnt);	
		
		Instruction sdiv = new Instruction("10011010110", "SDIV", Type.R);
		lookup.add(sdiv);	
		
		Instruction smulh = new Instruction("10011011010", "SMULH", Type.R);
		lookup.add(smulh);	
		
		Instruction stur = new Instruction("11111000000", "STUR", Type.D);
		lookup.add(stur);
		
		Instruction sturb = new Instruction("00111000000", "STURB", Type.D);
		lookup.add(sturb);
		
		Instruction sturd = new Instruction("11111100000", "STURD", Type.R);
		lookup.add(sturd);
		
		Instruction sturh = new Instruction("01111000000", "STURH", Type.D);
		lookup.add(sturh);
		
		Instruction sturs = new Instruction("0111100000", "STURS", Type.D);
		lookup.add(sturs);
		
		Instruction stursw = new Instruction("10111000000", "STURSW", Type.D);
		lookup.add(stursw);
		
		Instruction sub = new Instruction("11001011000", "SUB", Type.R);
		lookup.add(sub);
		
		Instruction subi = new Instruction("1101000100", "SUBI", Type.I);
		lookup.add(subi);
		
		Instruction subis = new Instruction("1111000100", "SUBIS", Type.I);
		lookup.add(subis);
		
		Instruction subs = new Instruction("11101011000", "SUBS", Type.R);
		lookup.add(subs);
		
		Instruction udiv = new Instruction("10011010110", "UDIV", Type.R);
		lookup.add(udiv);
		
		Instruction umulh = new Instruction("10011011110", "UMULH", Type.R);
		lookup.add(umulh);
	}
	
	public Instruction getInstuction(String bytes)
	{

		for(int i = 0; i<lookup.size(); i++)
		{
			Instruction inst = lookup.get(i);
			String op = inst.getOpcode();
			String temp = bytes.substring(0, op.length());
			if(op.equals(bytes.substring(0, op.length())))
			{
				return lookup.get(i);
			}
		}
		return null;
	}
	
	public String decode(String bytes)
	{
		String decode = "";
		
		Instruction inst = getInstuction(bytes);
		if(inst == null) {
			return "";
		}
		
		instructionLine++;
		if(inst.getType() == Type.R)
		{
			r_type(inst, bytes);
		}
		else if(inst.getType() == Type.I)
		{
			i_type(inst, bytes);
		}
		else if(inst.getType() == Type.CB)
		{
			cb_type(inst, bytes);
		}
		else if(inst.getType() == Type.B)
		{
			b_type(inst, bytes);
		}
		return decode;
	}
	
	private String r_type(Instruction inst, String byteString)
	{
		String temp = "";
		int Rd = Integer.parseInt(byteString.substring(27), 2);
		int Rn = Integer.parseInt(byteString.substring(22, 27), 2);
		int Shamt = Integer.parseInt(byteString.substring(16, 22), 2);
		int Rm = Integer.parseInt(byteString.substring(11, 16), 2);
		
		/*
		 * Include a conditional for LSL and RSL, look into how the shift
		 * amount is stored in the emulation
		 */
		if(Shamt == 0)
		{
			temp = inst.getLeg() + " X" + Rd + " X" + Rn + " X" + Rm;
			System.out.println(temp);
		}
		else
		{
			
		}
		
		return temp;
	}
	
	private String i_type(Instruction inst, String byteString)
	{
		String temp = "", substring;
		int Rd = Integer.parseInt(byteString.substring(27), 2);
		int Rn = Integer.parseInt(byteString.substring(22, 27), 2);
		int Imm = Integer.parseInt(byteString.substring(11, 22), 2);
		
		
		temp += inst.getLeg() + " X" + Rd + " X" + Rn + " #" + Imm;
		System.out.println(temp);
		
		
		return temp;
	}
	private String cb_type(Instruction inst, String byteString)
	{
		String temp = "";
		int condBranchAddress = Integer.parseInt(byteString.substring(8, 27), 2);
		int Rt = Integer.parseInt(byteString.substring(27), 2);
		
		if(labelList.get(instructionLine + condBranchAddress) == null)
		{
			String l_name = "label" + labelCounter;
			labelList.put(instructionLine, l_name);
			labelCounter++;
		}
		
		temp += inst.getLeg() + " X" + Rt + " " 
				+ labelList.get(instructionLine);
		System.out.println(temp);
		return temp;
	}
	
	private String b_type(Instruction inst, String byteString)
	{
		String temp = "";
		int condBranchAddress = Integer.parseInt(byteString.substring(6), 2);
		if(labelList.get(instructionLine + condBranchAddress) == null)
		{
			String l_name = "label" + labelCounter;
			labelList.put(instructionLine, l_name);
			labelCounter++;
		}
		temp += inst.getLeg() + " " + labelList.get(instructionLine);
		System.out.println(temp);
		return temp;
	}
	
	
}

