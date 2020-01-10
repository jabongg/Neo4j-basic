package externals;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.security.InvalidKeyException;
import java.util.HashMap;
import java.util.Map;

public class AWSTAzure {
}

package com.minda.iconnect.aws.s3;

        import com.amazonaws.AmazonClientException;
        import com.amazonaws.AmazonServiceException;
        import com.amazonaws.auth.BasicAWSCredentials;
        import com.amazonaws.services.s3.AmazonS3;
        import com.amazonaws.services.s3.AmazonS3Client;
        import com.amazonaws.services.s3.model.*;
        import com.microsoft.azure.storage.CloudStorageAccount;
        import com.microsoft.azure.storage.StorageException;
        import com.microsoft.azure.storage.blob.CloudBlobClient;
        import com.microsoft.azure.storage.blob.CloudBlockBlob;
        import com.minda.iconnect.util.InvoiceUtil;
        import org.apache.commons.io.IOUtils;
        import org.slf4j.Logger;
        import org.slf4j.LoggerFactory;
        import org.springframework.beans.factory.annotation.Value;
        import org.springframework.stereotype.Service;

        import java.io.ByteArrayInputStream;
        import java.io.File;
        import java.io.IOException;
        import java.io.InputStream;
        import java.net.URISyntaxException;
        import java.security.InvalidKeyException;
        import java.util.HashMap;
        import java.util.Map;

/**
 * Created by rohit on 4/9/15.
 */
@Service(value = "s3FileOperationService")
public class S3FileOperationServiceImpl implements S3FileOperationService {

    @Value("${bucketName}")
    private String bucketName;
    @Value("${awsAccessKey}")
    private String awsAccessKey;
    @Value("${awsSecretKey}")
    private String awsSecretKey;
    @Value("${azure.storage.connection.string}")
    private String connectionString;

    private static final Logger LOGGER = LoggerFactory.getLogger(S3FileOperationServiceImpl.class);
    public static final String WAYBILL = "WAYBILL";
    public static final String INVOICE = "INVOICE";
    private CloudBlobClient cloudBlobClient;

    @Override
    public void writeByteArrayToAmazonS3(byte[] content, String filePath) {
        InputStream stream = null;
        try {
            AmazonS3 client = new AmazonS3Client(
                    new BasicAWSCredentials(awsAccessKey, awsSecretKey));
            stream = new ByteArrayInputStream(content);
            ObjectMetadata meta = new ObjectMetadata();
            meta.setContentLength(content.length);
            meta.setContentType("application/pdf");
            client.putObject(bucketName, filePath, stream, meta);
            client.setObjectAcl(bucketName, filePath, CannedAccessControlList.AuthenticatedRead);
        } catch (AmazonServiceException ase) {
            LOGGER.error("inside writeByteArrayToAmazonS3" + ase +
                    "Caught an AmazonServiceException, which " +
                    "means your request made it " +
                    "to Amazon S3, but was rejected with an error response" +
                    " for some reason."
                    + "\nError Message:    " + ase.getMessage()
                    + "\nHTTP Status Code: " + ase.getStatusCode()
                    + "\nAWS Error Code:   " + ase.getErrorCode()
                    + "\nError Type:       " + ase.getErrorType()
                    + "\nRequest ID:       " + ase.getRequestId());
        } catch (AmazonClientException ace) {
            LOGGER.error("Caught an AmazonClientException, which " +
                    "means the client encountered " +
                    "an internal error while trying to " +
                    "communicate with S3, " +
                    "such as not being able to access the network."
                    + "\nError Message: " + ace.getMessage());
        } finally {
            if (stream != null) {
                try {
                    stream.close();
                } catch (IOException e) {
                    LOGGER.error("Exception in IO", e);
                }
            }
        }
    }

    @Override
    public void writeByteArrayToAmazonS3(byte[] content, String filePath, String contentType) {
        InputStream stream = null;
        try {
            AmazonS3 client = new AmazonS3Client(
                    new BasicAWSCredentials(awsAccessKey, awsSecretKey));
            stream = new ByteArrayInputStream(content);
            ObjectMetadata meta = new ObjectMetadata();
            meta.setContentLength(content.length);
            meta.setContentType(contentType);
            client.putObject(bucketName, filePath, stream, meta);
            client.setObjectAcl(bucketName, filePath, CannedAccessControlList.AuthenticatedRead);
        } catch (AmazonServiceException ase) {
            LOGGER.error("inside writeByteArrayToAmazonS3" + ase +
                    "Caught an AmazonServiceException, which " +
                    "means your request made it " +
                    "to Amazon S3, but was rejected with an error response" +
                    " for some reason."
                    + "\nError Message:    " + ase.getMessage()
                    + "\nHTTP Status Code: " + ase.getStatusCode()
                    + "\nAWS Error Code:   " + ase.getErrorCode()
                    + "\nError Type:       " + ase.getErrorType()
                    + "\nRequest ID:       " + ase.getRequestId());
        } catch (AmazonClientException ace) {
            LOGGER.error("Caught an AmazonClientException, which " +
                    "means the client encountered " +
                    "an internal error while trying to " +
                    "communicate with S3, " +
                    "such as not being able to access the network."
                    + "\nError Message: " + ace.getMessage());
        } finally {
            if (stream != null) {
                try {
                    stream.close();
                } catch (IOException e) {
                    LOGGER.error("Exception in IO", e);
                }
            }
        }
    }

    @Override
    public void deleteFileFromAmazonS3(String s3FilePath) {
        InputStream stream = null;
        try {
            AmazonS3 client = new AmazonS3Client(
                    new BasicAWSCredentials(awsAccessKey, awsSecretKey));
            DeleteObjectRequest deleteObjectRequest = new DeleteObjectRequest(bucketName, s3FilePath);
            client.deleteObject(deleteObjectRequest);
        } catch (AmazonServiceException ase) {
            LOGGER.error("inside deleteFileFromAmazonS3" + ase +
                    "Caught an AmazonServiceException, which " +
                    "means your request made it " +
                    "to Amazon S3, but was rejected with an error response" +
                    " for some reason."
                    + "\nError Message:    " + ase.getMessage()
                    + "\nHTTP Status Code: " + ase.getStatusCode()
                    + "\nAWS Error Code:   " + ase.getErrorCode()
                    + "\nError Type:       " + ase.getErrorType()
                    + "\nRequest ID:       " + ase.getRequestId());
        } catch (AmazonClientException ace) {
            LOGGER.error("Caught an AmazonClientException, which " +
                    "means the client encountered " +
                    "an internal error while trying to " +
                    "communicate with S3, " +
                    "such as not being able to access the network."
                    + "\nError Message: " + ace.getMessage());
        } finally {
            if (stream != null) {
                try {
                    stream.close();
                } catch (IOException e) {
                    LOGGER.error("Exception in IO", e);
                }
            }
        }
    }

    @Override
    public byte[] getByteArrayResourceFromAmazonS3(String key) {
        InputStream inputStream = null;
        try {
            LOGGER.debug("Downloading an object");
            inputStream = initializeS3(key);
            return IOUtils.toByteArray(inputStream);
        } catch (AmazonServiceException ase) {
            LOGGER.error("inside getByteArrayResourceFromAmazonS3" + ase +
                    "Caught an AmazonServiceException, which" +
                    " means your request made it " +
                    "to Amazon S3, but was rejected with an error response" +
                    " for some reason."
                    + "\n Source key:    " + key
                    + "\nError Message:    " + ase.getMessage()
                    + "\nHTTP Status Code: " + ase.getStatusCode()
                    + "\nAWS Error Code:   " + ase.getErrorCode()
                    + "\nError Type:       " + ase.getErrorType()
                    + "\nRequest ID:       " + ase.getRequestId());
        } catch (AmazonClientException ace) {
            LOGGER.error("Caught an AmazonClientException, which means" +
                    " the client encountered " +
                    "an internal error while trying to " +
                    "communicate with S3, " +
                    "such as not being able to access the network."
                    + "\nError Message: " + ace.getMessage());
        } catch (IOException e) {
            LOGGER.error("IOException while fetching the invoice as attachment", e);
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e) {
                LOGGER.error("Exception in IO", e);
            }
        }
        return null;
    }

    @Override
    public File getFileFromAmazonS3(String sourceLocation, String targetLocation) {
        InputStream inputStream = null;
        try {
            LOGGER.debug("Downloading an object");
            inputStream = initializeS3(sourceLocation);
            return InvoiceUtil.saveBinaryFile(inputStream, targetLocation);
        } catch (AmazonServiceException ase) {
            LOGGER.error("inside getFileFromAmazonS3" + ase +
                    "Caught an AmazonServiceException, which" +
                    " means your request made it " +
                    "to Amazon S3, but was rejected with an error response" +
                    " for some reason."
                    + "\n Source key:    " + sourceLocation
                    + "\nError Message:    " + ase.getMessage()
                    + "\nHTTP Status Code: " + ase.getStatusCode()
                    + "\nAWS Error Code:   " + ase.getErrorCode()
                    + "\nError Type:       " + ase.getErrorType()
                    + "\nRequest ID:       " + ase.getRequestId());
        } catch (AmazonClientException ace) {
            LOGGER.error("Caught an AmazonClientException, which means" +
                    " the client encountered " +
                    "an internal error while trying to " +
                    "communicate with S3, " +
                    "such as not being able to access the network."
                    + "\nError Message: " + ace.getMessage());
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e) {
                LOGGER.error("Exception in IO", e);
            }
        }
        return null;
    }

    @Override
    public Map<String, Integer> saveFilesFromFolderAndGetCountsForWayBillAndInvoice(String folderLocation, String destinationLocation) {
        AmazonS3 s3Client = new AmazonS3Client(new BasicAWSCredentials(awsAccessKey, awsSecretKey));
        Map<String, Integer> map = new HashMap<>(2);
        map.put(WAYBILL, 0);
        map.put(INVOICE, 0);
        try {
            ObjectListing objectListing = s3Client.listObjects(bucketName, folderLocation);
            for (S3ObjectSummary s3ObjectSummary : objectListing.getObjectSummaries()) {
                S3Object s3object = s3Client.getObject(new GetObjectRequest(
                        bucketName, s3ObjectSummary.getKey()));
                String[] pathOnS3 = s3ObjectSummary.getKey().split("/");
                String fileName = pathOnS3[pathOnS3.length - 1];
                if (fileName.contains(WAYBILL)) {
                    map.put(WAYBILL, map.get(WAYBILL) + 1);
                } else {
                    map.put(INVOICE, map.get(INVOICE) + 1);
                }
                InputStream inputStream = s3object.getObjectContent();
                InvoiceUtil.saveBinaryFile(inputStream, destinationLocation + "/" + fileName);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }

    @Override
    public void upload(Container container, File file, String contentType, String blobName) {
        try {
            CloudStorageAccount storageAccount = CloudStorageAccount.parse(connectionString);
            cloudBlobClient = storageAccount.createCloudBlobClient();
            CloudBlockBlob blob = cloudBlobClient.getContainerReference(container.getVal()).getBlockBlobReference(blobName);
            blob.deleteIfExists();
            blob.getProperties().setContentType(contentType);
            blob.uploadFromFile(file.getAbsolutePath());
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    @Override
    public void downloadToFile(String fileName, Container container, String localFilePath) {
        CloudBlockBlob blob = null;
        try {
            CloudStorageAccount storageAccount = CloudStorageAccount.parse(connectionString);
            cloudBlobClient = storageAccount.createCloudBlobClient();
            blob = cloudBlobClient.getContainerReference(container.getVal()).getBlockBlobReference(fileName);
            blob.downloadToFile(localFilePath);
        } catch (URISyntaxException | InvalidKeyException e) {
            e.printStackTrace();
        } catch (StorageException | IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void delete(Container container, String blobName) {
        CloudStorageAccount storageAccount = null;
        CloudBlockBlob blob = null;
        try {
            storageAccount = CloudStorageAccount.parse(connectionString);
            cloudBlobClient = storageAccount.createCloudBlobClient();

            blob = cloudBlobClient.getContainerReference(container.getVal()).getBlockBlobReference(blobName);
            blob.delete();
        } catch (URISyntaxException | StorageException e) {
            e.printStackTrace();
        }
        catch (InvalidKeyException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void writeByteArrayToAmazonS3(byte[] content, String filePath, String bucketName,
                                         String awsAccessKey, String awsSecretKey, String contentType) {
        InputStream stream = null;
        try {
            AmazonS3 client = new AmazonS3Client(
                    new BasicAWSCredentials(awsAccessKey, awsSecretKey));
            stream = new ByteArrayInputStream(content);
            ObjectMetadata meta = new ObjectMetadata();
            meta.setContentLength(content.length);
            meta.setContentType(contentType);
            client.putObject(bucketName, filePath, stream, meta);
            client.setObjectAcl(bucketName, filePath, CannedAccessControlList.AuthenticatedRead);
        } catch (AmazonServiceException ase) {
            LOGGER.error("inside writeByteArrayToAmazonS3" + ase +
                    "Caught an AmazonServiceException, which " +
                    "means your request made it " +
                    "to Amazon S3, but was rejected with an error response" +
                    " for some reason."
                    + "\nError Message:    " + ase.getMessage()
                    + "\nHTTP Status Code: " + ase.getStatusCode()
                    + "\nAWS Error Code:   " + ase.getErrorCode()
                    + "\nError Type:       " + ase.getErrorType()
                    + "\nRequest ID:       " + ase.getRequestId());
        } catch (AmazonClientException ace) {
            LOGGER.error("Caught an AmazonClientException, which " +
                    "means the client encountered " +
                    "an internal error while trying to " +
                    "communicate with S3, " +
                    "such as not being able to access the network."
                    + "\nError Message: " + ace.getMessage());
        } finally {
            if (stream != null) {
                try {
                    stream.close();
                } catch (IOException e) {
                    LOGGER.error("Exception in IO", e);
                }
            }
        }
    }

    private InputStream initializeS3(String key) {
        AmazonS3 s3Client = new AmazonS3Client(new BasicAWSCredentials(awsAccessKey, awsSecretKey));
        S3ObjectInputStream inputStream = null;
        LOGGER.debug("Downloading an object");
        S3Object s3object = s3Client.getObject(new GetObjectRequest(
                bucketName, key));
        LOGGER.debug("Content-Type: " +
                s3object.getObjectMetadata().getContentType());
        inputStream = s3object.getObjectContent();
        return inputStream;
    }
}