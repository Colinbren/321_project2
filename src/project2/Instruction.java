package project2;

public class Instruction {

private String opcode;
	
	private String leg;
	
	private Type type;
	
	public Instruction(String opcode, String leg, Type type)
	{
		this.opcode = opcode;
		this.leg = leg;
		this.type = type;
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

}
