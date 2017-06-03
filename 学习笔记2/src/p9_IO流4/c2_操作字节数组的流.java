package p9_IO流4;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

/* 操作字节数组的流:ByteArrayInputStream和ByteArrayOutputStream。
 * 这个流操作的源和目的都是内存，扩展，所有操作数组的流，它们的源和目的都是内存。
 * ByteArrayInputStream：包含一个内部缓冲区，该缓冲区包含从流中读取的字节。内部计数器跟踪 read 方法要提供的下一个字节。 
 * ByteArrayOutputStream：实现了一个输出流，其中的数据被写入一个 byte 数组。缓冲区会随着数据的不断写入而自动增长。
 * 关于这两个流，它们的关闭方法是无效的，因为它们操作的是内存，没有调用底层资源。类中的方法在关闭此流后仍可被调用。
 * 
 * 适用情况：如果源是内存，用ByteArrayInputStream；如果目的是内存，用ByteArrayOutputStream。
 * 
 * 与操作字节数组的流相类似的还有：操作字符数组的流，操作字符串的流。
 */
public class c2_操作字节数组的流 {

	public static void main(String[] args) {
		ByteArrayInputStream bais = new ByteArrayInputStream("abcdefg".getBytes());
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		
		int ch = 0;
		while ((ch=bais.read())!=-1) {
			baos.write(ch);
		}
		System.out.println(baos.toString());
	}

}
