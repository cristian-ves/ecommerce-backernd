


SET search_path TO public;

INSERT INTO role (name) VALUES
('Admin'),
('Moderator'),
('Logistics'),
('User');

INSERT INTO usr (role, name, password, email) VALUES
(1, 'Admin One', 'admin123', 'admin@ecommerce.com');

INSERT INTO usr (role, name, password, email) VALUES
(2, 'Moderator One', 'mod123', 'mod1@ecommerce.com'),
(2, 'Moderator Two', 'mod123', 'mod2@ecommerce.com'),
(2, 'Moderator Three', 'mod123', 'mod3@ecommerce.com'),
(2, 'Moderator Four', 'mod123', 'mod4@ecommerce.com'),
(2, 'Moderator Five', 'mod123', 'mod5@ecommerce.com');

INSERT INTO usr (role, name, password, email) VALUES
(3, 'Logistics One', 'log123', 'log1@ecommerce.com'),
(3, 'Logistics Two', 'log123', 'log2@ecommerce.com'),
(3, 'Logistics Three', 'log123', 'log3@ecommerce.com');

INSERT INTO usr (role, name, password, email) VALUES
(4, 'User One', 'user123', 'user1@ecommerce.com'),
(4, 'User Two', 'user123', 'user2@ecommerce.com'),
(4, 'User Three', 'user123', 'user3@ecommerce.com'),
(4, 'User Four', 'user123', 'user4@ecommerce.com'),
(4, 'User Five', 'user123', 'user5@ecommerce.com'),
(4, 'User Six', 'user123', 'user6@ecommerce.com'),
(4, 'User Seven', 'user123', 'user7@ecommerce.com'),
(4, 'User Eight', 'user123', 'user8@ecommerce.com'),
(4, 'User Nine', 'user123', 'user9@ecommerce.com'),
(4, 'User Ten', 'user123', 'user10@ecommerce.com');

INSERT INTO category (name) VALUES
('Technology'),
('Home'),
('Academic'),
('Personal'),
('Decoration'),
('Other');

INSERT INTO item (name, description, image, price, category, usr, new, rating, rates, accepted, stock) VALUES
('Smartphone X1', 'High-end smartphone with 128GB storage', 'https://images.pexels.com/photos/699122/pexels-photo-699122.jpeg', 599.99, 1, 10, true, 4.2, 12, true, 8),
('Laptop Pro 14', 'Slim 14-inch laptop for work and study', 'https://images.pexels.com/photos/18105/pexels-photo.jpg', 1099.99, 1, 10, false, 3.8, 15, true, 12),
('Bluetooth Speaker', 'Portable wireless speaker with great bass', 'https://images.pexels.com/photos/1279365/pexels-photo-1279365.jpeg', 79.99, 1, 10, true, 4.5, 20, true, 4),
('Desk Lamp', 'LED desk lamp with adjustable brightness', 'https://images.pexels.com/photos/1112598/pexels-photo-1112598.jpeg', 39.99, 2, 10, false, 4.0, 10, true, 15),
('Office Chair', 'Ergonomic chair with lumbar support', 'https://images.pexels.com/photos/3937174/pexels-photo-3937174.jpeg', 129.99, 2, 10, true, 4.7, 18, true, 7),
('Textbook: Modern Physics', 'University-level physics book', 'https://images.pexels.com/photos/34379156/pexels-photo-34379156.jpeg', 59.99, 3, 10, false, 4.1, 14, true, 11),
('Leather Wallet', 'Compact brown leather wallet', 'https://images.pexels.com/photos/33428338/pexels-photo-33428338.jpeg', 24.99, 4, 10, true, 4.8, 21, true, 1),
('Wrist Watch', 'Minimalist stainless steel watch', 'https://images.pexels.com/photos/1120275/pexels-photo-1120275.jpeg', 199.99, 4, 10, false, 3.9, 17, true, 9),
('Wall Art Canvas', 'Abstract art canvas for living room decor', 'https://images.pexels.com/photos/6373487/pexels-photo-6373487.jpeg', 89.99, 5, 10, true, 4.3, 11, true, 6),
('Gift Box Set', 'Personalized gift box with accessories', 'https://images.pexels.com/photos/6102557/pexels-photo-6102557.jpeg', 49.99, 6, 10, true, 4.6, 19, true, 14);

INSERT INTO item (name, description, image, price, category, usr, new, rating, rates, accepted, stock) VALUES
('Gaming Mouse GX100', 'Ergonomic RGB gaming mouse', 'https://images.pexels.com/photos/2115256/pexels-photo-2115256.jpeg', 59.99, 1, 11, true, 4.2, 16, true, 3),
('Mechanical Keyboard K1', 'RGB backlit mechanical keyboard', 'https://images.pexels.com/photos/18311093/pexels-photo-18311093.jpeg', 99.99, 1, 11, false, 4.4, 22, true, 10),
('Smartwatch FitBand', 'Waterproof fitness tracker watch', 'https://images.pexels.com/photos/1080745/pexels-photo-1080745.jpeg', 129.99, 1, 11, true, 3.7, 12, true, 5),
('Scented Candle Set', 'Lavender and vanilla candle pack', 'https://images.pexels.com/photos/5854427/pexels-photo-5854427.jpeg', 29.99, 2, 11, false, 4.1, 18, true, 13),
('Cushion Set', 'Soft decorative cushions for sofa', 'https://images.pexels.com/photos/6207459/pexels-photo-6207459.jpeg', 34.99, 2, 11, true, 4.5, 21, true, 8),
('Mathematics Workbook', 'Exercises for algebra and geometry', 'https://images.pexels.com/photos/6238006/pexels-photo-6238006.jpeg', 19.99, 3, 11, false, 3.9, 10, true, 2),
('Perfume', 'Floral fragrance for everyday use', 'https://images.pexels.com/photos/1190829/pexels-photo-1190829.jpeg', 54.99, 4, 11, true, 4.7, 23, true, 15),
('Sunglasses Classic', 'UV protection classic frame', 'https://images.pexels.com/photos/701877/pexels-photo-701877.jpeg', 44.99, 4, 11, false, 4.0, 15, true, 6),
('Wall Clock', 'Minimal design clock for living room', 'https://images.pexels.com/photos/191703/pexels-photo-191703.jpeg', 39.99, 5, 11, true, 4.3, 14, true, 1),
('Notebook Set', 'Set of 3 decorative notebooks', 'https://images.pexels.com/photos/5712485/pexels-photo-5712485.jpeg', 14.99, 6, 11, true, 4.6, 17, true, 10);

INSERT INTO item (name, description, image, price, category, usr, new, rating, rates, accepted, stock) VALUES
('Tablet S8', '8-inch tablet with 64GB memory', 'https://images.pexels.com/photos/1334597/pexels-photo-1334597.jpeg', 249.99, 1, 12, false, 4.3, 19, true, 14),
('Wireless Headphones', 'Noise-cancelling Bluetooth headphones', 'https://images.pexels.com/photos/610945/pexels-photo-610945.jpeg', 149.99, 1, 12, true, 4.5, 20, true, 7),
('USB-C Charger', 'Fast charging adapter 45W', 'https://images.pexels.com/photos/33061130/pexels-photo-33061130.jpeg', 29.99, 1, 12, true, 4.0, 12, true, 3),
('Ceramic Mug Set', 'Set of 4 coffee mugs', 'https://images.pexels.com/photos/5825722/pexels-photo-5825722.jpeg', 24.99, 2, 12, false, 4.1, 15, true, 9),
('Table Lamp Vintage', 'Classic lamp for nightstand', 'https://images.pexels.com/photos/1129413/pexels-photo-1129413.jpeg', 44.99, 2, 12, true, 4.4, 18, true, 12),
('English Dictionary', 'Comprehensive English dictionary', 'https://images.pexels.com/photos/29242209/pexels-photo-29242209.jpeg', 39.99, 3, 12, false, 4.2, 16, true, 5),
('Leather Belt', 'Black leather belt for men', 'https://images.pexels.com/photos/89783/belts-belt-buckle-leather-metal-89783.jpeg', 29.99, 4, 12, true, 4.6, 21, true, 11),
('Makeup Bag', 'Compact travel makeup organizer', 'https://images.pexels.com/photos/3373730/pexels-photo-3373730.jpeg', 19.99, 4, 12, false, 3.9, 13, true, 14),
('Vase Modern', 'Decorative vase for flowers', 'https://images.pexels.com/photos/34388156/pexels-photo-34388156.jpeg', 34.99, 5, 12, true, 4.5, 19, true, 8),
('Keychain Set', 'Personalized keychains', 'https://images.pexels.com/photos/114741/pexels-photo-114741.jpeg', 9.99, 6, 12, true, 4.8, 25, true, 2);

INSERT INTO item (name, description, image, price, category, usr, new, rating, rates, accepted, stock) VALUES
('Smart TV 50"', '4K Ultra HD smart television', 'https://images.pexels.com/photos/1444416/pexels-photo-1444416.jpeg', 599.99, 1, 13, true, 4.6, 20, true, 10),
('Wireless Keyboard', 'Bluetooth keyboard for tablets and PCs', 'https://images.pexels.com/photos/28396251/pexels-photo-28396251.jpeg', 49.99, 1, 13, false, 4.2, 15, true, 4),
('Mouse Pad RGB', 'Gaming mouse pad with RGB lights', 'https://images.pexels.com/photos/4792731/pexels-photo-4792731.jpeg', 34.99, 1, 13, true, 4.0, 13, true, 13),
('Wooden Desk', 'Minimalist home office desk', 'https://images.pexels.com/photos/37347/office-sitting-room-executive-sitting.jpg', 199.99, 2, 13, false, 4.4, 17, true, 6),
('Floor Lamp', 'Tall floor lamp with fabric shade', 'https://images.pexels.com/photos/112811/pexels-photo-112811.jpeg', 89.99, 2, 13, true, 4.1, 14, true, 15),
('Programming Book', 'Introduction to Python programming', 'https://images.pexels.com/photos/1181671/pexels-photo-1181671.jpeg', 39.99, 3, 13, false, 4.5, 19, true, 8),
('Travel Backpack', 'Durable water-resistant backpack', 'https://images.pexels.com/photos/34368420/pexels-photo-34368420.jpeg', 69.99, 4, 13, true, 4.3, 16, true, 1),
('Wristband Fitness', 'Activity tracker wristband', 'https://images.pexels.com/photos/1432039/pexels-photo-1432039.jpeg', 49.99, 4, 13, false, 4.2, 12, true, 11),
('Wall Mirror', 'Round decorative mirror for bedroom', 'https://images.pexels.com/photos/7055718/pexels-photo-7055718.jpeg', 79.99, 5, 13, true, 4.7, 21, true, 5),
('Gift Candle Box', 'Gift set with candles and aroma oils', 'https://images.pexels.com/photos/6102399/pexels-photo-6102399.jpeg', 44.99, 6, 13, false, 4.4, 18, true, 9);

INSERT INTO item (name, description, image, price, category, usr, new, rating, rates, accepted, stock) VALUES
('Laptop Air 13', 'Lightweight ultrabook laptop', 'https://images.pexels.com/photos/812264/pexels-photo-812264.jpeg', 899.99, 1, 14, true, 4.5, 20, true, 12),
('External SSD', '1TB portable solid state drive', 'https://images.pexels.com/photos/30758128/pexels-photo-30758128.jpeg', 119.99, 1, 14, false, 4.2, 15, true, 7),
('Bluetooth Earbuds', 'Wireless earbuds with case', 'https://images.pexels.com/photos/3780681/pexels-photo-3780681.jpeg', 99.99, 1, 14, true, 4.0, 12, true, 1),
('Dining Set', '4-person dining table set', 'https://images.pexels.com/photos/8251772/pexels-photo-8251772.jpeg', 399.99, 2, 14, false, 4.3, 18, true, 10),
('Curtains Beige', '2-panel blackout curtains', 'https://images.pexels.com/photos/34368434/pexels-photo-34368434.jpeg', 59.99, 2, 14, true, 4.1, 14, true, 13),
('Science Book', 'General science introduction book', 'https://images.pexels.com/photos/12467838/pexels-photo-12467838.jpeg', 34.99, 3, 14, false, 4.4, 19, true, 5),
('Sunglasses Sport', 'UV-protected polarized sunglasses', 'https://images.pexels.com/photos/19431254/pexels-photo-19431254.jpeg', 69.99, 4, 14, true, 4.6, 22, true, 15),
('Backpack Casual', 'Casual daily-use backpack', 'https://images.pexels.com/photos/704805/pexels-photo-704805.jpeg', 49.99, 4, 14, false, 4.3, 17, true, 2),
('Painting Abstract', 'Abstract art for living room wall', 'https://images.pexels.com/photos/34323553/pexels-photo-34323553.jpeg', 99.99, 5, 14, true, 4.5, 21, true, 4),
('Gift Card Pack', 'Gift card bundle with envelope', 'https://images.pexels.com/photos/5876727/pexels-photo-5876727.jpeg', 19.99, 6, 14, true, 4.2, 15, true, 11);

INSERT INTO item (name, description, image, price, category, usr, new, rating, rates, accepted, stock) VALUES
('Gaming Monitor 27"', 'High resolution gaming monitor', 'https://images.pexels.com/photos/33050960/pexels-photo-33050960.jpeg', 299.99, 1, 15, true, 4.6, 20, true, 8),
('Webcam HD', '1080p streaming webcam', 'https://images.pexels.com/photos/28940577/pexels-photo-28940577.jpeg', 79.99, 1, 15, true, 4.2, 16, true, 14),
('Throw Blanket', 'Soft fleece throw blanket', 'https://images.pexels.com/photos/1248583/pexels-photo-1248583.jpeg', 29.99, 2, 15, false, 4.1, 15, true, 3),
('History Book', 'World history encyclopedia', 'https://images.pexels.com/photos/3109167/pexels-photo-3109167.jpeg', 49.99, 3, 15, true, 4.3, 17, true, 12),
('Wallet Slim', 'Slim minimalist wallet', 'https://images.pexels.com/photos/14401881/pexels-photo-14401881.jpeg', 19.99, 4, 15, false, 4.5, 19, true, 9),
('Bracelet Silver', 'Sterling silver bracelet', 'https://images.pexels.com/photos/27790601/pexels-photo-27790601.jpeg', 59.99, 4, 15, true, 4.2, 16, true, 5),
('Decorative Plant', 'Potted green plant for home decor', 'https://images.pexels.com/photos/34368097/pexels-photo-34368097.jpeg', 25.99, 5, 15, true, 4.7, 22, true, 1),
('Aromatherapy Set', 'Relaxing oils and diffuser', 'https://images.pexels.com/photos/6800784/pexels-photo-6800784.jpeg', 34.99, 6, 15, false, 4.4, 18, true, 11);

INSERT INTO item (name, description, image, price, category, usr, new, rating, rates, accepted, stock) VALUES
('Drone Mini X', 'Compact camera drone with stabilizer', 'https://images.pexels.com/photos/7822516/pexels-photo-7822516.jpeg', 399.99, 1, 16, true, 4.5, 20, true, 13),
('VR Headset', 'Virtual reality headset for gaming', 'https://images.pexels.com/photos/3183164/pexels-photo-3183164.jpeg', 299.99, 1, 16, false, 4.2, 16, true, 7),
('Smart Plug', 'WiFi controllable outlet device', 'https://images.pexels.com/photos/29091470/pexels-photo-29091470.jpeg', 24.99, 1, 16, true, 4.0, 12, true, 2),
('Wall Shelf', 'Wooden floating wall shelf', 'https://images.pexels.com/photos/7494566/pexels-photo-7494566.jpeg', 49.99, 2, 16, false, 4.3, 18, true, 15),
('Floor Rug', 'Decorative area rug', 'https://images.pexels.com/photos/8089158/pexels-photo-8089158.jpeg', 79.99, 2, 16, true, 4.1, 14, true, 4),
('Calculus Book', 'Advanced calculus textbook', 'https://images.pexels.com/photos/5775/calculator-scientific.jpg', 59.99, 3, 16, false, 4.5, 19, true, 10),
('Wallet Leather', 'Full-grain leather bi-fold wallet', 'https://images.pexels.com/photos/4452635/pexels-photo-4452635.jpeg', 34.99, 4, 16, true, 4.2, 15, true, 6),
('Sunglasses Trendy', 'Stylish sunglasses model', 'https://images.pexels.com/photos/46710/pexels-photo-46710.jpeg', 49.99, 4, 16, false, 4.4, 17, true, 1),
('Wall Poster', 'Inspirational quote poster', 'https://images.pexels.com/photos/937786/pexels-photo-937786.jpeg', 14.99, 5, 16, true, 4.6, 21, true, 9),
('Gift Basket', 'Assorted gift basket set', 'https://images.pexels.com/photos/15801491/pexels-photo-15801491.jpeg', 44.99, 6, 16, true, 4.3, 16, true, 12);

INSERT INTO item (name, description, image, price, category, usr, new, rating, rates, accepted, stock) VALUES
('Smart Glasses', 'AR glasses with notifications', 'https://images.pexels.com/photos/8098274/pexels-photo-8098274.jpeg', 349.99, 1, 17, false, 4.4, 18, true, 5),
('Portable Projector', 'Mini projector for movies', 'https://images.pexels.com/photos/31726725/pexels-photo-31726725.jpeg', 249.99, 1, 17, true, 4.1, 14, true, 14),
('Cable Organizer', 'Neat cable management kit', 'https://images.pexels.com/photos/31886525/pexels-photo-31886525.jpeg', 14.99, 1, 17, false, 4.3, 16, true, 8),
('Candle Holder', 'Metal candle holder set', 'https://images.pexels.com/photos/34396445/pexels-photo-34396445.jpeg', 24.99, 2, 17, true, 4.5, 19, true, 3),
('Bedside Lamp', 'Lamp with touch control', 'https://images.pexels.com/photos/4112558/pexels-photo-4112558.jpeg', 44.99, 2, 17, false, 4.2, 15, true, 11),
('Notebook Academic', 'Notebooks for school classes', 'https://images.pexels.com/photos/544115/pexels-photo-544115.jpeg', 9.99, 3, 17, true, 4.0, 12, true, 6),
('Passport Cover', 'Leather cover for passports', 'https://images.pexels.com/photos/6755222/pexels-photo-6755222.jpeg', 14.99, 4, 17, false, 4.3, 16, true, 15),
('Watch Sport', 'Sports watch with timer', 'https://images.pexels.com/photos/4482932/pexels-photo-4482932.jpeg', 89.99, 4, 17, true, 4.1, 14, true, 1),
('Vase Ceramic', 'Ceramic vase for flowers', 'https://images.pexels.com/photos/34366677/pexels-photo-34366677.jpeg', 24.99, 5, 17, true, 4.4, 18, true, 10),
('Gift Wrap Set', 'Decorative wrapping paper set', 'https://images.pexels.com/photos/6578933/pexels-photo-6578933.jpeg', 12.99, 6, 17, false, 4.2, 15, true, 4);

INSERT INTO item (name, description, image, price, category, usr, new, rating, rates, accepted, stock) VALUES
('Gaming Laptop 15', 'Graphics laptop for gaming', 'https://images.pexels.com/photos/19012051/pexels-photo-19012051.jpeg', 1299.99, 1, 18, true, 4.7, 22, true, 12),
('Smart Speaker', 'Voice assistant smart speaker', 'https://images.pexels.com/photos/1072851/pexels-photo-1072851.jpeg', 129.99, 1, 18, false, 4.4, 18, true, 7),
('Power Strip Surge', 'Surge-protected power strip', 'https://images.pexels.com/photos/15000981/pexels-photo-15000981.jpeg', 29.99, 1, 18, true, 4.2, 16, true, 11),
('Kitchen Knife Set', 'Stainless steel kitchen knives', 'https://images.pexels.com/photos/237996/pexels-photo-237996.jpeg', 89.99, 2, 18, false, 4.5, 20, true, 3),
('Cookware Set', 'Non-stick pots and pans for home cooking', 'https://images.pexels.com/photos/31110049/pexels-photo-31110049.jpeg', 129.99, 2, 18, true, 4.3, 17, true, 9),
('Grammar Guide', 'Comprehensive English grammar guide', 'https://images.pexels.com/photos/6929185/pexels-photo-6929185.jpeg', 29.99, 3, 18, false, 4.1, 15, true, 14),
('Travel Bag', 'Weekend duffle bag', 'https://images.pexels.com/photos/1058959/pexels-photo-1058959.jpeg', 49.99, 4, 18, true, 4.4, 18, true, 8),
('Necklace Gold', '18K gold-plated necklace', 'https://images.pexels.com/photos/34399039/pexels-photo-34399039.jpeg', 79.99, 4, 18, true, 4.6, 21, true, 2),
('Wall Painting', 'Nature-inspired wall art', 'https://images.pexels.com/photos/2065650/pexels-photo-2065650.jpeg', 99.99, 5, 18, false, 4.5, 19, true, 15),
('Gift Box Deluxe', 'Luxury gift box set', 'https://images.pexels.com/photos/6833327/pexels-photo-6833327.jpeg', 59.99, 6, 18, true, 4.3, 16, true, 6);

INSERT INTO item (name, description, image, price, category, usr, new, rating, rates, accepted, stock) VALUES
('Tablet Pro 11', '11-inch tablet with stylus support', 'https://images.pexels.com/photos/3785868/pexels-photo-3785868.jpeg', 499.99, 1, 19, false, 4.4, 18, true, 1),
('Wireless Router', 'Dual-band WiFi 6 router', 'https://images.pexels.com/photos/1024697/pexels-photo-1024697.jpeg', 89.99, 1, 19, true, 4.2, 15, true, 10),
('Mechanical Keyboard RGB', 'Gaming keyboard with clicky switches', 'https://images.pexels.com/photos/18382824/pexels-photo-18382824.jpeg', 109.99, 1, 19, true, 4.5, 20, true, 13),
('Sofa Set', 'Modern 3-piece sofa set', 'https://images.pexels.com/photos/6980714/pexels-photo-6980714.jpeg', 799.99, 2, 19, false, 4.3, 17, true, 5),
('Lamp Desk Classic', 'Adjustable reading desk lamp', 'https://images.pexels.com/photos/1125137/pexels-photo-1125137.jpeg', 39.99, 2, 19, true, 4.1, 14, true, 8),
('History Atlas', 'World history illustrated atlas', 'https://images.pexels.com/photos/3837487/pexels-photo-3837487.jpeg', 44.99, 3, 19, false, 4.4, 19, true, 12),
('Wallet Compact', 'Compact black wallet for men', 'https://images.pexels.com/photos/915915/pexels-photo-915915.jpeg', 29.99, 4, 19, true, 4.6, 22, true, 4),
('Earrings Set', 'Silver earrings set', 'https://images.pexels.com/photos/6716445/pexels-photo-6716445.jpeg', 39.99, 4, 19, false, 4.2, 16, true, 15),
('Flower Vase', 'Glass vase for table decoration', 'https://images.pexels.com/photos/1103562/pexels-photo-1103562.jpeg', 19.99, 5, 19, true, 4.5, 18, true, 2),
('Gift Card Premium', 'Premium gift card with envelope', 'https://images.pexels.com/photos/5963137/pexels-photo-5963137.jpeg', 24.99, 6, 19, false, 4.3, 15, true, 7);