/**
 *
 */
package com.example.ProjetoPos.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;
import javax.sql.rowset.serial.SerialBlob;

/**
 * @author <a href="mailto:renan.silveira@unoesc.edu.br">Renan Silveira</a>
 * @since 06/03/2024
 */
public class ProjetoPosUtil {

	public static final byte[] getBytesFromBlob(final Blob dados) {
		if (dados == null) {
			return new byte[0];
		}
		return ProjetoPosUtil.toByteArray(dados);
	}

	public static final Blob getBlobFromBytes(final byte[] dados) {
		try {
			return new SerialBlob(dados);
		} catch (final SQLException e) {
			return null;
		}
		// restos mortais: return Hibernate.createBlob(dados);
	}

	private static final byte[] toByteArray(final Blob fromBlob) {
		final ByteArrayOutputStream baos = new ByteArrayOutputStream();
		try {
			return ProjetoPosUtil.toByteArrayImpl(fromBlob, baos);
		} catch (final SQLException | IOException e) {
			throw new RuntimeException(e);
		} finally {
			if (baos != null) {
				try {
					baos.close();
				} catch (final IOException ex) {}
			}
		}
	}

	private static final byte[] toByteArrayImpl(final Blob fromBlob, final ByteArrayOutputStream baos)
			throws SQLException, IOException {
		final byte[] buf = new byte[4000];
		final InputStream is = fromBlob.getBinaryStream();
		try {
			for (;;) {
				final int dataSize = is.read(buf);

				if (dataSize == -1) {
					break;
				}
				baos.write(buf, 0, dataSize);
			}
		} finally {
			if (is != null) {
				try {
					is.close();
				} catch (final IOException ex) {}
			}
		}
		return baos.toByteArray();
	}
}
