import java.util.Arrays;

class FT_ArrayList<T>
{
	private Object []	elementData;
	private int 		size;

	public FT_ArrayList()
	{
		size = 0;
		elementData = new Object [size];
	}

	public FT_ArrayList(int Capacity)
	{
		size = Capacity;
		elementData = new Object [size];
	}

	public int size()
	{
		return (size);
	}

	@SuppressWarnings("unchecked")
	public T get(int index)
	{
		if (index < 0 || index >= size)
			throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
		return ((T)elementData[index]);
	}

	public boolean add(T element)
	{
		Object [] 		oldValue;

		oldValue = elementData;
		elementData = Arrays.copyOf(elementData, ++size);
		elementData[size - 1] = element;
		return (true);
	}

	public boolean isEmpty()
	{
		return (size == 0);
	}
}