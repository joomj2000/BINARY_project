import cv2
import numpy as np
from PIL import Image
import os

detector = cv2.CascadeClassifier('.\haarcascade_frontalface_default.xml')

def getImagesAndLabels(path):
    imagePaths = [os.path.join(path,f) for f in os.listdir(path)]
    # listdir == 해당 디렉토리 내 파일 리스트
    # path + file Name == 경로 list 만들기

    faceSamples = []
    ids = []
    for imagePath in imagePaths: # 각 파일마다
        # 흑백 변환
        # 8 bits pixel 이미지로 변환 => 0 ~ 255의 수로 표현 가능한 흑백 이미지 생성
        PIL_img = Image.open(imagePath).convert('L') # L : 8 bit pixel, bw
        img_numpy = np.array(PIL_img, 'uint8')

        # user id
        id = int(os.path.split(imagePath)[-1].split(".")[1])

        print(id)

        # 학습을 위한 얼굴 샘플
        faces = detector.detectMultiScale(img_numpy)
        for(x,y,w,h) in faces:
            faceSamples.append(img_numpy[y:y+h,x:x+w])
            ids.append(id)

    return faceSamples, ids

path = 'dataset'
# 유사 얼굴 찾아내는 모델
recognizer = cv2.face.LBPHFaceRecognizer_create()

print('\n Training faces. It will take a few seconds. Wait ...')
faces, ids = getImagesAndLabels(path)

recognizer.train(faces,np.array(ids)) #학습

recognizer.write('.\/train/trainer.yml')
print('\n {0} faces trained. Exiting Program'.format(len(np.unique(ids))))