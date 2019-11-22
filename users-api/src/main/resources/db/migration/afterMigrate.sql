INSERT INTO users(_email, _password, username)
VALUES ('quinto@mail.com', '123', 'quinto'),
('darkness@mail.com', '123', 'murphy'),
('hilldawg@mail.com', '123', 'clinton'),
('onionfan@mail.com', '123', 'davos'),
('1337codr@mail.com', '123', 'hax'),
('badstash@mail.com', '123', 'chaplin');

INSERT INTO posts(_title, _description, user_id)
VALUES ('disco party','This is big',1),
('the hampsterdance song', 'party on',2),
('owa', 'mark my words',3);

INSERT INTO comments(_text, post_id, username, user_id)
VALUES ('disco party is fun', 1, 'john', 1),
('the hampsterdance song is fun', 2, 'mary', 2),
('owa', 2, 'jane', 2);