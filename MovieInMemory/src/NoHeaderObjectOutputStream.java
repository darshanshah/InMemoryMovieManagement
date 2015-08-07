import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

// to remove the header from the Object output stream
public class NoHeaderObjectOutputStream extends ObjectOutputStream {
	public NoHeaderObjectOutputStream(OutputStream outputStream)
			throws IOException {
		super(outputStream);
	}

	@Override
	protected void writeStreamHeader() {
	}
}