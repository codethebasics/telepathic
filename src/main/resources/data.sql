SELECT 1;
INSERT INTO TB_MENU (ID, TITLE, PARENT_MENU_ID) VALUES (0, 'Selecione a opção desejada.', null);
INSERT INTO TB_MENU (ID, TITLE, PARENT_MENU_ID) VALUES (1, 'Encoders', 0);
INSERT INTO TB_MENU (ID, TITLE, PARENT_MENU_ID) VALUES (2, 'Decoders', 0);
INSERT INTO TB_MENU (ID, TITLE, PARENT_MENU_ID) VALUES (3, 'One Time Password (OTP)', 0);
INSERT INTO TB_MENU (ID, TITLE, PARENT_MENU_ID) VALUES (4, 'BCrypt encoder', 1);
INSERT INTO TB_MENU (ID, TITLE, PARENT_MENU_ID) VALUES (5, 'Base64 encoder', 1);
INSERT INTO TB_MENU (ID, TITLE, PARENT_MENU_ID) VALUES (6, 'MD5 encoder', 1);
INSERT INTO TB_MENU (ID, TITLE, PARENT_MENU_ID) VALUES (7, 'SHA-1 encoder', 1);
INSERT INTO TB_MENU (ID, TITLE, PARENT_MENU_ID) VALUES (8, 'Base64 decoder', 2);