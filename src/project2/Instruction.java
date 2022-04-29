package project2;

public class Instruction {

private String opcode;
	
	private String leg;
	private String decoded_instruction;
	private Type type;
	private int line;
	
	public Instruction(String opcode, String leg, Type type)
	{
		this.opcode = opcode;
		this.leg = leg;
		this.type = type;
		decoded_instruction = "";
	}
	
	public Instruction(Instruction base)
	{
		this.opcode = base.opcode;
		this.leg = base.leg;
		this.type = type;
		this.decoded_instruction = base.decoded_instruction;
		this.type = base.type;
	}
	public String getOpcode()
	{
		return opcode;
	}
	public void setOpcode(String opcode)
	{
		this.opcode = opcode;
	}
	public String getLeg()
	{
		return leg;
	}
	public void setLeg(String leg)
	{
		this.leg = leg;
	}
	public Type getType()
	{
		return type;
	}
	public void setType(Type type)
	{
		this.type = type;
	}
	public void setLine(int l)
	{
		line = l;
	}
	public int getLine()
	{
		return line;
	}
	public void setDecodedInst(String d)
	{
		decoded_instruction = d;
	}
	public String getDecodedInst()
	{
		return decoded_instruction;
	}

}
