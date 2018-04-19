class FT_ArrayList<T>
{
	private Object[]	value;
	private int 		size;

	public FT_ArrayList()
	{
		this.size = 1;
		this.value = new Object[size];
	}

	public FT_ArrayList(int initialCapacity)
	{
		if (initialCapacity < 0)
			initialCapacity = 10;
		this.size = initialCapacity;
	}

	public boolean add(T value)
	{
		if (ensureCapacity(size + 1))
		{
			this.value[size++] = value;
			return (true);
		}
		return (false);
	}

	private boolean ensureCapacity(int minCapacity)
	{
		int 	oldCapacity;
		int 	i;

		oldCapacity = value.length;
		if (minCapacity > oldCapacity) 
		{
			Object oldData[] = value;
			i = -1;
            while (++i < oldData.length - 1)
            	value[i] = oldData[i];
            return (true);
        }
        return (false);
	}

	public T get(int index)
	{
		if (index >= 0 && index < size)
			return (valueData(index));
		throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
	}

	@SuppressWarnings("unchecked")
	private T valueData(int index)
	{
		return ((T)value[index]);
	}

	public int size()
	{
		return (size);
	}
}