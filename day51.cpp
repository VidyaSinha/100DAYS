//Given the root of a binary tree, replace the value of each node in the tree with the sum of all its cousins' values.

Two nodes of a binary tree are cousins if they have the same depth with different parents.

Return the root of the modified tree.

Note that the depth of a node is the number of edges in the path from the root node to it.

 

class Solution {
public:
    TreeNode* replaceValueInTree(TreeNode* root) {
        if (!root) return nullptr;

        queue<TreeNode*> q;
        int prev = root->val;
        q.push(root);

        while (!q.empty()) {
            int size = q.size();
            int curr = 0;

            while (size > 0) {
                TreeNode* temp = q.front();
                q.pop();

                int leftRight = (temp->left ? temp->left->val : 0) + (temp->right ? temp->right->val : 0);

                if (temp->left) {
                    temp->left->val = leftRight;
                    q.push(temp->left);
                }

                if (temp->right) {
                    temp->right->val = leftRight;
                    q.push(temp->right);
                }

                curr += leftRight;
                temp->val = prev - temp->val;
                size--;
            }

            prev = curr;
        }

        return root;
    }
};
