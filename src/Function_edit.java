public class Function_edit {
    Nodepad nodepad;
    public Function_edit(Nodepad nodepad){
        this.nodepad=nodepad;
    }
    public void Undo(){
        nodepad.undoManager.undo();
    }
    public void Redo(){
        nodepad.undoManager.redo();
    }
}
