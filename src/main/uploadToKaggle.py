from kaggle.api.kaggle_api_extended import KaggleApi
import os

#initializing the api and authenticating it
api = KaggleApi()
api.authenticate()

folderPath = os.path.abspath("csv_files")

#function to upload the dataset
def uploaddataset():
    api.dataset_create_new("csv_files")

#function to update the dataset
def updatedataset(path):
    api.dataset_create_version(path, "Daily update")

if __name__ == "__main__":
    #use uploadDataset() once then comment it out and un-comment updateDataset()
    #uploaddataset()
    try:
        input("Press Enter to exit...")
        updatedataset(folderPath)
    except ValueError:
        input("value error, press enter to exit...")