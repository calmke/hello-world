
class Date8{	//������
	final int DAYS_BEFORE_MONTH[] = { 0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334, 365 };
	
	private int year;		//��
	private int month;		//��
	private int day;		//��
	private int totalDays;	//�������Ǵӹ�ԪԪ��1��1�տ�ʼ�ĵڼ���

	public Date8(int year, int month, int day){	//���ꡢ�¡��չ�������
		this.year = year;
		this.month = month;
		this.day = day;
		if (day<=0 || day>getMaxDay()){
			//throw new Exception("Invalid date: ");
			System.out.println("Invalid date: ");
			show();
			System.out.println();
			System.exit(1);
		}
		int years = year-1;
		totalDays = years*365+years/4-years/100+years/400+DAYS_BEFORE_MONTH[month-1]+day;
		if (isLeapYear() && month>2)
			totalDays++;
	}
	
	final public int getYear() { return year; }
	final public int getMonth() { return month; }
	final public int getDay() { return day; }
	final public int getMaxDay(){		//��õ����ж�����
		if (isLeapYear() && month == 2)
			return 29;
		else
			return DAYS_BEFORE_MONTH[month] - DAYS_BEFORE_MONTH[month - 1];
	}
	
	public boolean isLeapYear(){	//�жϵ����Ƿ�Ϊ����
		return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
	}
	
	final void show(){			//�����ǰ����
		System.out.println(getYear() + "-" + getMonth() + "-" + getDay());
	}
	
	//������������֮��������	
	final int substruct (final Date8 date) {
		return totalDays - date.totalDays;
	}
};