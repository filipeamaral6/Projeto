CREATE TABLE `transaction` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `value` double NOT NULL,
  `account_iban` varchar(255) NOT NULL,
  `client_cc` int(11) NOT NULL,
  `type` varchar(100) NOT NULL,
  `created_at` datetime NOT NULL DEFAULT current_timestamp(),
  `description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `transaction_account_fk` (`account_iban`),
  KEY `transaction_client_cc_fk` (`client_cc`),
  CONSTRAINT `transaction_account_fk` FOREIGN KEY (`account_iban`) REFERENCES `account` (`iban`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `transaction_client_cc_fk` FOREIGN KEY (`client_cc`) REFERENCES `client` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
