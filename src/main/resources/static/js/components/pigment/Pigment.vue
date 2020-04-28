<template>
  <v-data-table
      :headers="headers"
      :items="pigmentList"
      sort-by="pigmentIndex"
      class="elevation-1"
  >
    <template v-slot:top>
      <v-toolbar flat color="white">
        <v-toolbar-title>Pigments</v-toolbar-title>
        <v-divider
            class="mx-4"
            inset
            vertical
        ></v-divider>
        <v-spacer></v-spacer>
        <v-dialog v-model="dialog" max-width="500px">
          <template v-slot:activator="{ on }">
            <v-btn color="primary" dark class="mb-2" v-on="on">New pigment</v-btn>
          </template>
          <v-card>
            <v-card-title>
              <span v-if="editedItem.id">Edit {{editedItem.pigmentIndex}}</span>
              <span v-else>Create</span>
            </v-card-title>

            <v-card-text>
              <v-container>
                <v-row>
                  <v-col cols="12" sm="6" md="4">
                    <v-text-field v-model="pigmentList.pigmentIndex" label="Pigment index"></v-text-field>
                  </v-col>
                </v-row>
              </v-container>
            </v-card-text>

            <v-card-actions>
              <v-spacer></v-spacer>
              <v-btn color="blue darken-1" text @click="close">Cancel</v-btn>
              <v-btn color="blue darken-1" text @click="save(editedItem)">Save</v-btn>
            </v-card-actions>
          </v-card>
        </v-dialog>
      </v-toolbar>
    </template>
    <template v-slot:item.actions="{ item }">
      <v-icon
          small
          class="mr-2"
          @click="showEditedDialog(item)"
      >
        mdi-pencil
      </v-icon>
      <v-icon
          small
          @click="deletePigment(item)"
      >
        mdi-delete
      </v-icon>
    </template>
  </v-data-table>
</template>

<script>
  import axios from "axios";

  export default {
    name: "Pigment",
    data() {

      return {
        dialog: false,
        headers: [
          {
            text: 'Pigment',
            align: 'start',
            sortable: false,
            value: 'pigmentIndex',
          },
          {text: 'Pigment Index', value: 'pigmentIndex'},
          {text: 'Actions', value: 'actions', sortable: false}
        ],
        editedIndex: -1,
        pigmentList: [],
        defaultItem: {
          pigmentIndex: ''
        },
        editedItem: {}
      }
    },

    mounted() {
      axios.get('http://localhost:8080/pigment')
      .then(result => {
        this.pigmentList = result.data
      }, error => {
        console.error(error);
      });
    },

    methods: {

      showEditedDialog(item) {
        this.editedItem = item || {};
        this.dialog = !this.dialog
      },

      deletePigment(item) {
        const index = this.pigmentList.indexOf(item);
        if (confirm('Are you sure you want to delete this pigment?') && this.pigmentList.splice(index, 1)) {
          axios.delete('http://localhost:8080/pigment/' + item.id, {
            pigmentIndex: this.pigmentList.pigmentIndex
          });
        }
      },

      close() {
        this.dialog = false;
        setTimeout(() => {
          this.editedItem = Object.assign({}, this.defaultItem);
          this.editedIndex = -1
        }, 300)
      },

      save(item) {

        let id = item.id;

        if (id) {
          axios.put('http://localhost:8080/pigment/' + id, {
            pigmentIndex: this.pigmentList.pigmentIndex
          });
        } else {
          axios.post('http://localhost:8080/pigment', {
            pigmentIndex: this.pigmentList.pigmentIndex
          });
          this.pigmentList.pigmentIndex = ''
        }

        this.close()
      }
    }
  }
</script>

<style scoped>

</style>