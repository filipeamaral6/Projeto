CREATE TABLE `transfer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `destination_iban` varchar(255) NOT NULL,
  `transaction_id` int(11) NOT NULL,
  `employee_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `transfer_transaction_fk` (`transaction_id`),
  KEY `transfer_employee_fk` (`employee_id`),
  CONSTRAINT `transfer_employee_fk` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `transfer_transaction_fk` FOREIGN KEY (`transaction_id`) REFERENCES `transaction` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

