import cv2

imagePath = "image:1.jpg" # Path to the image
img = cv2.imread(imagePath) # Read the image
print(img.shape) # (height, width, channels)

gray_image = cv2.cvtColor(img, cv2.COLOR_BGR2GRAY) # Convert the image to grayscale
print(gray_image.shape) # (height, width)

face_classifier = cv2.CascadeClassifier(cv2.data.haarcascades + "haarcascade_frontalface_default.xml") # Load the face classifier

face = face_classifier.detectMultiScale(
    gray_image, scaleFactor=1.1, minNeighbors=5, minSize=(40, 40) # Detect faces in the image 
)

# Loop through each detected face in the 'face' list
for (x, y, w, h) in face:
    # Draw a rectangle around the face on the image 'img'
    # (x, y) is the top-left corner of the rectangle
    # (x+w, y+h) is the bottom-right corner of the rectangle
    # (0, 255, 0) is the color of the rectangle in BGR format (green in this case)
    # 4 is the thickness of the rectangle border
    cv2.rectangle(img, (x, y), (x+w, y+h), (0, 255, 0), 4)

img_rgb = cv2.cvtColor(img, cv2.COLOR_BGR2RGB) # Convert the image to RGB format

import matplotlib.pyplot as plt



plt.figure(figsize=(20,10))
plt.imshow(img_rgb)
plt.axis('off')
plt.show()