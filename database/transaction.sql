CREATE TABLE `transaction` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `value` double NOT NULL,
  `account_iban` varchar(255) NOT NULL,
  `created_at` datetime NOT NULL DEFAULT current_timestamp(),
  `client_id` int(11) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `transaction_account_fk` (`account_iban`),
  KEY `transaction_client_fk` (`client_id`),
  CONSTRAINT `transaction_account_fk` FOREIGN KEY (`account_iban`) REFERENCES `account` (`iban`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `transaction_client_fk` FOREIGN KEY (`client_id`) REFERENCES `client` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
