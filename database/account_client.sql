CREATE TABLE `account_client` (
  `account_id` int(11) NOT NULL,
  `client_id` int(11) NOT NULL,
  KEY `account_client_account_fk` (`account_id`),
  KEY `account_client_client_fk` (`client_id`),
  CONSTRAINT `account_client_account_fk` FOREIGN KEY (`account_id`) REFERENCES `account` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `account_client_client_fk` FOREIGN KEY (`client_id`) REFERENCES `client` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
