from kaggle.api.kaggle_api_extended import KaggleApi

#initializing the api and authenticating it
api = KaggleApi()
api.authenticate()

#function to upload the dataset
def uploadDataset():
    api.dataset_create_new("csv_files")

#function to update the dataset
def updateDataset():
    api.dataset_create_version("csv_files", "Daily update")

if __name__ == "__main__":
    #use uploadDataset() once then comment it out and un-comment updateDataset()
    #uploadDataset()
    updateDataset()